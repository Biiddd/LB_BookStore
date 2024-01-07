export const tableOption = {
  searchMenuSpan: 6,
  columnBtn: false,
  border: true,
  selection: true,
  index: false,
  indexLabel: '序号',
  stripe: true,
  menuAlign: 'center',
  menuWidth: 350,
  align: 'center',
  refreshBtn: true,
  searchSize: 'mini',
  addBtn: false,
  editBtn: false,
  delBtn: false,
  viewBtn: false,
  props: {
    label: 'label',
    value: 'value'
  },
  column: [{
    label: '书名',
    prop: 'prodName',
    search: true
  }, {
    label: '作者',
    prop: 'author',
    search: true
  }, {
    label: '出版社',
    prop: 'publisher',
    search: true
  }, {
    label: '原价',
    prop: 'oriPrice'
  }, {
    label: '现价',
    prop: 'price'
  }, {
    label: '库存',
    prop: 'totalStocks'
  }, {
    label: '图书图片',
    prop: 'pic',
    type: 'upload',
    width: 150,
    listType: 'picture-img'

  }, {
    width: 150,
    label: '状态',
    prop: 'status',
    search: true,
    slot: true,
    type: 'select',
    dicData: [
      {
        label: '未上架',
        value: 0
      }, {
        label: '上架',
        value: 1
      }
    ]
  }]
}
