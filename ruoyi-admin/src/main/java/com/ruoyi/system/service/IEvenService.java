package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Even;

/**
 * 自动化记录Service接口
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
public interface IEvenService 
{
    /**
     * 查询自动化记录
     * 
     * @param id 自动化记录主键
     * @return 自动化记录
     */
    public Even selectEvenById(Long id);

    /**
     * 查询自动化记录列表
     * 
     * @param even 自动化记录
     * @return 自动化记录集合
     */
    public List<Even> selectEvenList(Even even);

    /**
     * 新增自动化记录
     * 
     * @param even 自动化记录
     * @return 结果
     */
    public int insertEven(Even even);

    /**
     * 修改自动化记录
     * 
     * @param even 自动化记录
     * @return 结果
     */
    public int updateEven(Even even);

    /**
     * 批量删除自动化记录
     * 
     * @param ids 需要删除的自动化记录主键集合
     * @return 结果
     */
    public int deleteEvenByIds(Long[] ids);

    /**
     * 删除自动化记录信息
     * 
     * @param id 自动化记录主键
     * @return 结果
     */
    public int deleteEvenById(Long id);
}
