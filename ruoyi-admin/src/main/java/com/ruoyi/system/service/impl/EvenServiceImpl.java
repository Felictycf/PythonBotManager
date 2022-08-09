package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EvenMapper;
import com.ruoyi.system.domain.Even;
import com.ruoyi.system.service.IEvenService;

/**
 * 自动化记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
@Service
public class EvenServiceImpl implements IEvenService 
{
    @Autowired
    private EvenMapper evenMapper;

    /**
     * 查询自动化记录
     * 
     * @param id 自动化记录主键
     * @return 自动化记录
     */
    @Override
    public Even selectEvenById(Long id)
    {
        return evenMapper.selectEvenById(id);
    }

    /**
     * 查询自动化记录列表
     * 
     * @param even 自动化记录
     * @return 自动化记录
     */
    @Override
    public List<Even> selectEvenList(Even even)
    {
        return evenMapper.selectEvenList(even);
    }

    /**
     * 新增自动化记录
     * 
     * @param even 自动化记录
     * @return 结果
     */
    @Override
    public int insertEven(Even even)
    {
        return evenMapper.insertEven(even);
    }

    /**
     * 修改自动化记录
     * 
     * @param even 自动化记录
     * @return 结果
     */
    @Override
    public int updateEven(Even even)
    {
        return evenMapper.updateEven(even);
    }

    /**
     * 批量删除自动化记录
     * 
     * @param ids 需要删除的自动化记录主键
     * @return 结果
     */
    @Override
    public int deleteEvenByIds(Long[] ids)
    {
        return evenMapper.deleteEvenByIds(ids);
    }

    /**
     * 删除自动化记录信息
     * 
     * @param id 自动化记录主键
     * @return 结果
     */
    @Override
    public int deleteEvenById(Long id)
    {
        return evenMapper.deleteEvenById(id);
    }
}
