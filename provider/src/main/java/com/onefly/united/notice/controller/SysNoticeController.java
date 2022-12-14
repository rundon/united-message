package com.onefly.united.notice.controller;


import com.onefly.united.common.constant.Constant;
import com.onefly.united.common.page.PageData;
import com.onefly.united.common.user.SecurityUser;
import com.onefly.united.common.utils.Result;
import com.onefly.united.common.validator.AssertUtils;
import com.onefly.united.common.validator.ValidatorUtils;
import com.onefly.united.common.validator.group.AddGroup;
import com.onefly.united.common.validator.group.DefaultGroup;
import com.onefly.united.common.validator.group.UpdateGroup;
import com.onefly.united.notice.dto.SysNoticeDTO;
import com.onefly.united.notice.service.SysNoticeService;
import com.onefly.united.notice.service.SysNoticeUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;


/**
* 通知管理
*
* @author Mark Rundon
*/
@RestController
@RequestMapping("/api/notice")
@Api(tags="通知管理")
public class SysNoticeController {
    @Autowired
    private SysNoticeService sysNoticeService;
    @Autowired
    private SysNoticeUserService sysNoticeUserService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @PreAuthorize("hasAuthority('sys:notice:all')")
    public Result<PageData<SysNoticeDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<SysNoticeDTO> page = sysNoticeService.page(params);

        return new Result<PageData<SysNoticeDTO>>().ok(page);
    }

    @GetMapping("user/page")
    @ApiOperation("获取被通知的用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String"),
    })
    @PreAuthorize("hasAuthority('sys:notice:all')")
    public Result<PageData<SysNoticeDTO>> userPage(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<SysNoticeDTO> page = sysNoticeService.getNoticeUserPage(params);

        return new Result<PageData<SysNoticeDTO>>().ok(page);
    }

    @GetMapping("mynotice/page")
    @ApiOperation("获取我的通知")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String"),
    })
    public Result<PageData<SysNoticeDTO>> myNoticePage(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<SysNoticeDTO> page = sysNoticeService.getMyNoticePage(params);

        return new Result<PageData<SysNoticeDTO>>().ok(page);
    }

    @PutMapping("mynotice/read/{noticeId}")
    @ApiOperation("标记我的通知为已读")
    public Result read(@PathVariable("noticeId") Long noticeId){
        sysNoticeUserService.updateReadStatus(SecurityUser.getUserId(), noticeId);

        return new Result();
    }

    @GetMapping("mynotice/unread")
    @ApiOperation("我的通知未读读")
    public Result<Integer> unRead(){
        int count = sysNoticeUserService.getUnReadNoticeCount(SecurityUser.getUserId());

        return new Result<Integer>().ok(count);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @PreAuthorize("hasAuthority('sys:notice:all')")
    public Result<SysNoticeDTO> get(@PathVariable("id") Long id){
        SysNoticeDTO data = sysNoticeService.get(id);

        return new Result<SysNoticeDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    //@LogOperation("部署")("保存")
    @PreAuthorize("hasAuthority('sys:notice:all')")
    public Result save(@RequestBody SysNoticeDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        sysNoticeService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    //@LogOperation("部署")("修改")
    @PreAuthorize("hasAuthority('sys:notice:all')")
    public Result update(@RequestBody SysNoticeDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        sysNoticeService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    //@LogOperation("部署")("删除")
    @PreAuthorize("hasAuthority('sys:notice:all')")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        sysNoticeService.delete(ids);

        return new Result();
    }

}