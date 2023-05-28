import request from '@/utils/request'

// 查询会员列表
export function listMember(query) {
  return request({
    url: '/member/list',
    method: 'get',
    params: query
  })
}

// 查询会员详细
export function getMember(id) {
  return request({
    url: '/member/' + id,
    method: 'get'
  })
}

// 新增会员
export function addMember(data) {
  return request({
    url: '/member',
    method: 'post',
    data: data
  })
}

// 修改会员
export function updateMember(data) {
  return request({
    url: '/member',
    method: 'put',
    data: data
  })
}

// 删除会员
export function delMember(id) {
  return request({
    url: '/member/' + id,
    method: 'delete'
  })
}

// 导出会员
export function exportMember(query) {
  return request({
    url: '/member/export',
    method: 'get',
    params: query
  })
}

// 下载导入模板
export function importTemplate() {
  return request({
    url: '/member/importTemplate',
    method: 'get'
  });
}

