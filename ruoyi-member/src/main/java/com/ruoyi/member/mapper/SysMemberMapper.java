package com.ruoyi.member.mapper;

import com.ruoyi.member.domain.SysMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 会员Mapper接口
 * 
 * @author wei
 * @date 2022-07-29
 */
public interface SysMemberMapper extends BaseMapper<SysMember>
{
    /**
     * 查询会员
     * 
     * @param id 会员主键
     * @return 会员
     */
    public SysMember selectSysMemberById(Long id);

    /**
     * 查询会员列表
     * 
     * @param sysMember 会员
     * @return 会员集合
     */
    public List<SysMember> selectSysMemberList(SysMember sysMember);

    /**
     * 新增会员
     * 
     * @param sysMember 会员
     * @return 结果
     */
    public int insertSysMember(SysMember sysMember);

    /**
     * 修改会员
     * 
     * @param sysMember 会员
     * @return 结果
     */
    public int updateSysMember(SysMember sysMember);

    /**
     * 删除会员
     * 
     * @param id 会员主键
     * @return 结果
     */
    public int deleteSysMemberById(Long id);

    /**
     * 批量删除会员
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysMemberByIds(Long[] ids);
}
