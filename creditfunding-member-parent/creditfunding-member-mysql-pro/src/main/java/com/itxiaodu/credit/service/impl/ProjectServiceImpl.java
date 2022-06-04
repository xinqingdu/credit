package com.itxiaodu.credit.service.impl;

import com.itxiaodu.credit.entity.po.MemberConfirmInfoPO;
import com.itxiaodu.credit.entity.po.MessageReturnPO;
import com.itxiaodu.credit.entity.po.ProjectMemberInfoPO;
import com.itxiaodu.credit.entity.po.ProjectPO;
import com.itxiaodu.credit.entity.vo.*;
import com.itxiaodu.credit.mapper.*;
import com.itxiaodu.credit.service.api.ProjectService;
import com.itxiaodu.credit.utils.ResultType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional(readOnly = true)
@Service
public class ProjectServiceImpl implements ProjectService {
    ProjectServiceImpl() {

    }

    @Autowired
    ProjectPOMapper projectPOMapper;
    @Autowired
    ProjectItemPOMapper projectItemPOMapper;
    @Autowired
    ProjectMemberInfoPOMapper projectMemberInfoPOMapper;
    @Autowired
    MemberConfirmInfoPOMapper memberConfirmInfoPOMapper;
    @Autowired
    MessageReturnPOMapper messageReturnPOMapper;


    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public ResultType<String> saveProjectVO(ProjectVO projectVO, Integer memberId) {
        ProjectPO projectPO = new ProjectPO();
        projectPO.setDeployDate(new Date());
        projectPO.setMemberId(memberId);
        BeanUtils.copyProperties(projectVO, projectPO);
        projectPOMapper.insertSelective(projectPO);
        Integer projectPOId = projectPO.getId();

        List<Integer> typeIdList = projectVO.getTypeIdList();
        projectPOMapper.insertTypeRelationship(typeIdList, projectPOId);

        List<Integer> tagIdList = projectVO.getTagIdList();
        projectPOMapper.insertTagRelationship(tagIdList, projectPOId);

        List<String> detailPicturePathList = projectVO.getDetailPicturePathList();
        projectItemPOMapper.insertPathList(detailPicturePathList, projectPOId);

        ProjectMemberInfoVO memberInfoVO = projectVO.getProjectMemberInfoVO();
        ProjectMemberInfoPO projectMemberInfoPO = new ProjectMemberInfoPO();
        BeanUtils.copyProperties(memberInfoVO, projectMemberInfoPO);
        projectMemberInfoPO.setMemberId(memberId);
        projectMemberInfoPOMapper.insert(projectMemberInfoPO);

        List<MessageReturnVO> messageReturnList = projectVO.getMessageReturnList();
        List<MessageReturnPO> returnPOList = new ArrayList<>();
        for (MessageReturnVO messageReturn : messageReturnList) {
            MessageReturnPO messageReturnPO = new MessageReturnPO();
            BeanUtils.copyProperties(messageReturn, messageReturnPO);
            returnPOList.add(messageReturnPO);

        }
        messageReturnPOMapper.insertReturnPOList(returnPOList, projectPOId);

        MemberConfirmInfoVO memberConfirmInfoVO = projectVO.getMemberConfirmInfoVO();
        MemberConfirmInfoPO memberConfirmInfoPO = new MemberConfirmInfoPO();
        BeanUtils.copyProperties(memberConfirmInfoVO, memberConfirmInfoPO);
        memberConfirmInfoPO.setMemberId(memberId);
        memberConfirmInfoPOMapper.insert(memberConfirmInfoPO);

        return ResultType.successWithoutData();
    }

    @Override
    public List<CreditTypeVO> selectCreditTypeVO() {
        return projectPOMapper.selectCreditTypeVOList();
    }

    @Override
    public DetailProjectVO selectDetailProjectVO(Integer id) {
        try{
            DetailProjectVO detailProjectVO = projectPOMapper.selectDetailProjectVO(id);
            Integer status=detailProjectVO.getProjectStatus();
            Date dateDeploy=detailProjectVO.getDeployDate();
            Date currentDate=new Date();
            long from1 = dateDeploy.getTime();
            long to1 = currentDate.getTime();
            int days = detailProjectVO.getDays();

            int passDays = (int) ((to1 - from1) / (1000 * 60 * 60 * 24));

            int restDays=days-passDays;
            detailProjectVO.setLastDay(restDays);
            return detailProjectVO;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
