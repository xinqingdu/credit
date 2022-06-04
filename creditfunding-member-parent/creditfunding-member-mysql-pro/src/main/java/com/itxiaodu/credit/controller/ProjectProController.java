package com.itxiaodu.credit.controller;

import com.itxiaodu.credit.entity.vo.*;
import com.itxiaodu.credit.service.api.ProjectService;
import com.itxiaodu.credit.utils.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class ProjectProController {
    ProjectProController() {

    }

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/save/project/vo/remote")
    ResultType<String> saveProjectVORemote(@RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId) {
        try {
            projectService.saveProjectVO(projectVO, memberId);
            return ResultType.successWithoutData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultType.fail(e.getMessage());
        }
    }

    @RequestMapping("/select/credit/type/vo/remote")
    ResultType<List<CreditTypeVO>> selectCreditTypeVORemote() {
        try {
            List<CreditTypeVO> creditTypeVOS = projectService.selectCreditTypeVO();
            return ResultType.successWithData(creditTypeVOS);
        } catch (Exception e) {
//            e.printStackTrace();
            return ResultType.fail(e.getMessage());
        }
    }

    @RequestMapping("/select/detail/project/vo/remote")
    ResultType<DetailProjectVO> selectDetailProjectVORemote(@RequestParam("id") Integer projectId) {
        try {
            DetailProjectVO detailProjectVO = projectService.selectDetailProjectVO(projectId);
            return ResultType.successWithData(detailProjectVO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultType.fail(e.getMessage());
        }
    }



}
