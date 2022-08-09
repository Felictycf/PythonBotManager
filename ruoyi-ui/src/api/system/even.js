import request from '@/utils/request'

// 查询自动化记录列表
export function listEven(query) {
  return request({
    url: '/system/even/list',
    method: 'get',
    params: query
  })
}

// 查询自动化记录详细
export function getEven(id) {
  return request({
    url: '/system/even/' + id,
    method: 'get'
  })
}

// 新增自动化记录
export function addEven(data) {
  return request({
    url: '/system/even',
    method: 'post',
    data: data
  })
}

// 修改自动化记录
export function updateEven(data) {
  return request({
    url: '/system/even',
    method: 'put',
    data: data
  })
}

// 删除自动化记录
export function delEven(id) {
  return request({
    url: '/system/even/' + id,
    method: 'delete'
  })
}
