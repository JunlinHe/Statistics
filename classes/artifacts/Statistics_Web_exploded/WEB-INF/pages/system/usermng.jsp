<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2015/11/5
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="usermng_toolbar">
    <div class="btn-group">
        <button type="button" id="add_user" class="btn btn-default" data-toggle="tooltip" data-placement="bottom"
                title="添加用户" disabled>
            <i class="glyphicon glyphicon-plus"></i>
        </button>
        <button type="button" id="delete_row" class="btn btn-danger" data-toggle="tooltip"
                data-placement="bottom" title="删除用户" disabled>
            <i class="glyphicon glyphicon-trash"></i>
        </button>
    </div>

</div>
<table id="usermng_table">
</table>
<script>
    $(function(){
        var $table = $('#usermng_table'),
                $remove = $('#delete_row'),
                selections = [];

        /*bootstrap-table 本地数据*/
        //表格字段定义
        var table_colums=[
            {field: 'state',checkbox: true,align: 'center',valign: 'middle'},
            {title: '序号',field: 'id',align: 'center',valign: 'middle',sortable: true},
            {
                title: '姓名',field: 'userName',align: 'center',valign: 'middle',sortable: true,
                editable: {
                    type: 'text',//text|textarea|select|date|checklist
                    title: '修改姓名',
                    validate: function (value) {
                        value = $.trim(value);
                        if (!value) {
                            return '请输入有效内容';
                        }
                        var data = $table.bootstrapTable('getData'),
                                index = $(this).parents('tr').data('index');
                        console.log(data[index]);
                        return '';
                    }
                }

            },
            {
                title: '年龄',field: 'age',align: 'center',valign: 'middle',sortable: true,
                editable: {
                    type: 'text',
                    title: '修改年龄',

                    validate: function (value) {
                        value = $.trim(value);
                        if (!value) {
                            return '请输入有效内容';
                        }
                        if (!/^[0-9]*$/.test(value)) {
                            return '必须是数字'
                        }
                        var data = $table.bootstrapTable('getData'),
                                index = $(this).parents('tr').data('index');
                        console.log(data[index]);
                        return '';
                    }
                }
            },
            {title: '机器码',field: 'uuid',align: 'center',valign: 'middle',sortable: true},
            {
                title: '备注',field: 'dsc',align: 'center',valign: 'middle',sortable: true,
                editable: {
                    type: 'textarea',
                    title: '修改备注',
                    validate: function (value) {
                        value = $.trim(value);
                        if (!value) {
                            return '请输入有效内容';
                        }
                        var data = $table.bootstrapTable('getData'),
                                index = $(this).parents('tr').data('index');
                        console.log(data[index]);
                        return '';
                    }

                }
            },
            {
                field: 'operate',
                title: '操作',
                align: 'center',
                width: 150,
                events: operateEvents,
                formatter: operateFormatter
            }
        ], table_data=[
            {'id':'1','name':'张一','age':25,'gender':1,'desc':'哈哈'},
            {'id':'2','name':'张二','age':24,'gender':1,'desc':'哈哈'},
            {'id':'3','name':'张三','age':23,'gender':1,'desc':'哈哈'},
            {'id':'4','name':'张四','age':22,'gender':1,'desc':'哈哈'},
            {'id':'5','name':'张五','age':21,'gender':1,'desc':'哈哈'},
            {'id':'6','name':'张六','age':20,'gender':1,'desc':'哈哈'},
            {'id':'7','name':'张七','age':19,'gender':1,'desc':'哈哈'},
            {'id':'8','name':'张八','age':18,'gender':1,'desc':'哈哈'},
            {'id':'9','name':'张九','age':17,'gender':1,'desc':'哈哈'},
            {'id':'10','name':'张十','age':16,'gender':1,'desc':'哈哈'},
            {'id':'11','name':'张十一','age':15,'gender':1,'desc':'哈哈'},
            {'id':'12','name':'张十二','age':14,'gender':1,'desc':'哈哈'}
        ];


        $table.bootstrapTable({
            //classes:'',
            clickToSelect:true,
            columns:table_colums,
            //data:table_data,
            toolbar:'#usermng_toolbar',
            sidePagination: 'server', // client or server
            //totalRows: 0, // server side need to set

            method: 'get',
            url: '/user/select',
            //ajax: undefined,
            cache: true,
            contentType: 'application/json',
            dataType: 'json',

            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 50, 100],
            idField:'id',//id字段
            search: true,
            showColumns: true,
            showRefresh: true,
            showToggle: true,//显示切换卡片列表
            showExport: true,
            exportTypes: ['json', 'xml', 'txt', 'excel', 'doc', 'powerpoint', 'pdf'],
            striped:true,
            responseHandler:responseHandler

        }).on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table',function(){
            //控制按钮是否可用
            $('#add_user,#delete_row').prop('disabled',!$table.bootstrapTable('getSelections').length);

            // save your data, here just save the current page
            selections = getIdSelections();
            // push or splice the selections if you want to save all data selections
        });
        // sometimes footer render error.
        setTimeout(function () {
            $table.bootstrapTable('resetView');
        }, 200);

        $remove.click(function () {
            var ids = getIdSelections();
            $table.bootstrapTable('remove', {
                field: 'id',
                values: ids
            });
            $remove.prop('disabled', true);
        });

        function getIdSelections() {
            return $.map($table.bootstrapTable('getSelections'), function (row) {
                return row.id
            });
        }

        //处理服务器返回的 嵌套的json数据，例如只要json中的某一字段值做表格数据
        function responseHandler(res) {
            alert(res);
            $.each(res.rows, function (i, row) {
                row.state = $.inArray(row.id, selections) !== -1;
            });
            return res;
        }

        function operateFormatter(value, row, index) {
            return [
                '<div class="btn-group">',
                '<button type="button" class="btn btn-primary btn-xs like">',
                '<i class="glyphicon glyphicon-heart"></i> 点赞',
                '</button>  ',
                '<button type="button" class="btn btn-primary btn-xs remove">',
                '<i class="glyphicon glyphicon-remove"></i> 删除',
                '</button>',
                '</div>'
            ].join('');
        }
    });

    window.operateEvents = {
        'click .like': function (e, value, row, index) {
            var $modal = $('#fadeModal');
            $modal.modal('toggle');
            $modal.find('.modal-body').html('你点了一手好赞, row: ' + JSON.stringify(row));
            $('#fadeModal .btn.sky-save').on('click',function(){$modal.modal('hide')});

        },
        'click .remove': function (e, value, row, index) {

            var $modal = $('#confirmModal');
            $modal.modal('toggle');
            $modal.find('.modal-body').html('您确定要删除该行？');
            $modal.find('.btn.sky-save').on('click',function(){
                $table.bootstrapTable('remove', {
                    field: 'id',
                    values: [row.id]
                });
                $modal.modal('hide');
            });

        }
    };
</script>