package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Even;
import com.ruoyi.system.service.IEvenService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 自动化记录Controller
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
@RestController
@RequestMapping("/system/even")
public class EvenController extends BaseController
{
    @Autowired
    private IEvenService evenService;

    /**
     * 查询自动化记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:even:list')")
    @GetMapping("/list")
    public TableDataInfo list(Even even)
    {
        startPage();
        List<Even> list = evenService.selectEvenList(even);
        return getDataTable(list);
    }

    /**
     * 导出自动化记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:even:export')")
    @Log(title = "自动化记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Even even)
    {
        List<Even> list = evenService.selectEvenList(even);
        ExcelUtil<Even> util = new ExcelUtil<Even>(Even.class);
        util.exportExcel(response, list, "自动化记录数据");
    }

    /**
     * 获取自动化记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:even:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(evenService.selectEvenById(id));
    }

    /**
     * 新增自动化记录
     */
    @PreAuthorize("@ss.hasPermi('system:even:add')")
    @Log(title = "自动化记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Even even)
    {
        return toAjax(evenService.insertEven(even));
    }

    /**
     * 修改自动化记录
     */
    @PreAuthorize("@ss.hasPermi('system:even:edit')")
    @Log(title = "自动化记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Even even)
    {
        return toAjax(evenService.updateEven(even));
    }

    /**
     * 删除自动化记录
     */
    @PreAuthorize("@ss.hasPermi('system:even:remove')")
    @Log(title = "自动化记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(evenService.deleteEvenByIds(ids));
    }
}
