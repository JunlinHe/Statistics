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
    <div class="form-inline" role="form">
        <div class="form-group">
            <span>Offset: </span>
            <input name="offset" class="form-control w70" type="number" value="0">
        </div>
        <div class="form-group">
            <span>Limit: </span>
            <input name="limit" class="form-control w70" type="number" value="5">
        </div>
        <div class="form-group">
            <input name="search" class="form-control" type="text" placeholder="Search">
        </div>
        <button id="ok" type="submit" class="btn btn-default">OK</button>
    </div>
</div>
<table id="usermng_table">
</table>
<script>
    var $table = $('#usermng_table'),
            btObj,
            $remove = $('#delete_row'),
            selections = [];

    $(function(){

        /*bootstrap-table 本地数据*/
        //表格字段定义
        var table_colums=[
            {field: 'check',checkbox: true,align: 'center',valign: 'middle'},
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
            {title: '序列号',field: 'serialNumber',align: 'center',valign: 'middle',sortable: true},
            {title: '状态',field: 'state',checkbox: false,align: 'center',valign: 'middle',sortable: true},
            {title: '地址',field: 'address',align: 'center',valign: 'middle',sortable: true},
            {title: '公司',field: 'company',align: 'center',valign: 'middle',sortable: true},
            {title: '电话',field: 'phone',align: 'center',valign: 'middle',sortable: true},
            {title: 'email',field: 'email',align: 'center',valign: 'middle',sortable: true},
            {title: 'IP',field: 'ip',align: 'center',valign: 'middle',sortable: true},
            {title: '客户端',field: 'client',align: 'center',valign: 'middle',sortable: true},
            {title: '最后登录时间',field: 'lastLoginTime',align: 'center',valign: 'middle',sortable: true},
            {
                title: '备注',field: 'dsc',align: 'center',valign: 'middle',
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
        ];


        btObj=$table.bootstrapTable({
            //classes:'',
            clickToSelect:true,
            columns:table_colums,
            //data:table_data,
            toolbar:'#usermng_toolbar',
            sidePagination: 'server', // client or server 分页方式是服务端还是本地
            //totalRows: 0, // server side need to set

            method: 'post',
            url: '/user/select',
            //ajax: undefined,
            //cache: true,
            //contentType: 'application/json',
            //dataType: 'json',
            queryParamsType: '',//默认limit 开启RESTFul 风格的分页参数
            queryParams:function(params){
                //ajax提交参数Object {search: undefined, sort: undefined, order: "asc", limit: 5, offset: 0}
                //Object {pageSize: 5, pageNumber: 1, searchText: undefined, sortName: undefined, sortOrder: "asc"…}
                out(params);
                //params.searchText = "改好";
                //params.sortName = 'id';
                return params;
            },
            //ajaxOptions:'',//ajax参数

            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 50, 100],
            idField:'id',//id字段
            search: true,
            searchTimeOut:1000,//自动搜索时间
            strictSearch:true,
            onSearch:function(){
                console.log("啦啦啦啦")
            },
            showColumns: true,
            showRefresh: true,
            showToggle: true,//显示切换卡片列表
            showExport: true,
            exportTypes: ['json', 'xml', 'txt', 'excel', 'doc', 'powerpoint', 'pdf'],

            advancedSearch:true,//高级搜索
            formatAdvancedSearch: function() {
                return '高级搜索';
            },
            formatAdvancedCloseButton: function() {
                return "关闭";
            },
            onColumnAdvancedSearch: function (field, text) {
                console.log(field);
                console.log(text);
                return false;
            },

            striped: true,//条纹分割行
            resizable:true,//列可改变大小
            headerOnly:true,//只有表头可拖拽
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
            console.log("返回数据")
            res.rows =res.data;
            $.each(res.rows, function (i, row) {
                row.check = $.inArray(row.id, selections) !== -1;
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