package com.ruoyi.member.service;

import com.ruoyi.member.domain.SysMember;

import java.util.List;

/**
 * 会员Service接口
 * 
 * @author wei
 * @date 2022-07-29
 */
public interface ISysMemberService 
{
    /**
     * 查询会员
     * 
     * @param id 会员主键
     * @return 会员
     */
    SysMember selectSysMemberById(Long id);

    /**
     * 查询会员列表
     * 
     * @param sysMember 会员
     * @return 会员集合
     */
    List<SysMember> selectSysMemberList(SysMember sysMember);

    /**
     * 新增会员
     * 
     * @param sysMember 会员
     * @return 结果
     */
    int insertSysMember(SysMember sysMember);

    /**
     * 修改会员
     * 
     * @param sysMember 会员
     * @return 结果
     */
    int updateSysMember(SysMember sysMember);

    /**
     * 批量删除会员
     * 
     * @param ids 需要删除的会员主键集合
     * @return 结果
     */
    int deleteSysMemberByIds(Long[] ids);

    /**
     * 删除会员信息
     * 
     * @param id 会员主键
     * @return 结果
     */
    int deleteSysMemberById(Long id);

    /**
     * 导入数据
     *
     * @param sysMemberList 排污口水质数据
     * @return String
     */
    String importSysMember(List<SysMember> sysMemberList);
}
