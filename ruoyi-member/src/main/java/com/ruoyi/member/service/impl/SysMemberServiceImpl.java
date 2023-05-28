package com.ruoyi.member.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.member.domain.SysMember;
import com.ruoyi.member.mapper.SysMemberMapper;
import com.ruoyi.member.service.ISysMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员Service业务层处理
 * 
 * @author wei
 * @date 2022-07-29
 */
@Service
@RequiredArgsConstructor
public class SysMemberServiceImpl implements ISysMemberService 
{
    private final SysMemberMapper sysMemberMapper;

    /**
     * 查询会员
     * 
     * @param id 会员主键
     * @return 会员
     */
    @Override
    public SysMember selectSysMemberById(Long id)
    {
        return sysMemberMapper.selectSysMemberById(id);
    }

    /**
     * 查询会员列表
     * 
     * @param sysMember 会员
     * @return 会员
     */
    @Override
    public List<SysMember> selectSysMemberList(SysMember sysMember)
    {
        return sysMemberMapper.selectSysMemberList(sysMember);
    }

    /**
     * 新增会员
     * 
     * @param sysMember 会员
     * @return 结果
     */
    @Override
    public int insertSysMember(SysMember sysMember)
    {
        sysMember.setCreateTime(DateUtils.getNowDate());
        return sysMemberMapper.insertSysMember(sysMember);
    }

    /**
     * 修改会员
     * 
     * @param sysMember 会员
     * @return 结果
     */
    @Override
    public int updateSysMember(SysMember sysMember)
    {
        return sysMemberMapper.updateSysMember(sysMember);
    }

    /**
     * 批量删除会员
     * 
     * @param ids 需要删除的会员主键
     * @return 结果
     */
    @Override
    public int deleteSysMemberByIds(Long[] ids)
    {
        return sysMemberMapper.deleteSysMemberByIds(ids);
    }

    /**
     * 删除会员信息
     * 
     * @param id 会员主键
     * @return 结果
     */
    @Override
    public int deleteSysMemberById(Long id)
    {
        return sysMemberMapper.deleteSysMemberById(id);
    }

    @Override
    public String importSysMember(List<SysMember> sysMemberList) {
        Assert.isTrue(ObjectUtil.isNotEmpty(sysMemberList), "导入数据不能为空");
        int successNum = 0;
        for (SysMember sysMember : sysMemberList) {
            SysMember add = BeanUtil.toBean(sysMember, SysMember.class);
            insertSysMember(add);
            successNum++;
        }
        String msg = String.format("导入完成，共计 %d 条数据，成功 %d 条！", sysMemberList.size(), successNum);
        if (successNum != sysMemberList.size()) {
            msg = msg + String.format("失败 %d 条！", sysMemberList.size() - successNum);
        }
        return msg;
    }
}
