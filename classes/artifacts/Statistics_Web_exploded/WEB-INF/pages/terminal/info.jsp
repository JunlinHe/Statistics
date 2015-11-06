<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2015/11/4
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-md-2">

        <div class="panel  panel-default">
            <div class="panel-heading">终端分组</div>
            <div class="panel-body">
                <!--fuelux树模板-->
                <div class="fuelux">
                    <ul id="myTree" class="tree tree-folder-select" role="tree" id="myTree">
                        <li class="tree-branch hide" data-template="treebranch" role="treeitem" aria-expanded="false">
                            <div class="tree-branch-header">
                                <button class="glyphicon icon-caret glyphicon-play"><span class="sr-only">Open</span>
                                </button>
                                <button class="tree-branch-name">
                                    <span class="glyphicon icon-folder glyphicon-folder-close"></span>
                                    <span class="tree-label"></span>
                                </button>
                            </div>
                            <ul class="tree-branch-children" role="group"></ul>
                            <div class="tree-loader" role="alert">加载中。。。</div>
                        </li>
                        <li class="tree-item hide" data-template="treeitem" role="treeitem">
                            <button class="tree-item-name">
                                <span class="glyphicon icon-item fueluxicon-bullet"></span>
                                <span class="tree-label"></span>
                            </button>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-10">
        <!--table-->
        <div id="toolbar">
            <div class="btn-group">
                <button type="button" id="play" class="btn btn-primary" data-toggle="tooltip" data-placement="bottom"
                        title="播放" disabled>
                    <i class="glyphicon glyphicon-play"></i>
                </button>
                <button type="button" id="pause" class="btn btn-primary" data-toggle="tooltip" data-placement="bottom"
                        title="暂停" disabled>
                    <i class="glyphicon glyphicon-pause"></i>
                </button>
                <button type="button" id="stop" class="btn btn-primary" data-toggle="tooltip" data-placement="bottom"
                        title="停止" disabled>
                    <i class="glyphicon glyphicon-stop"></i>
                </button>
            </div>
            <div class="btn-group">
                <button type="button" id="volume" class="btn btn-default" data-toggle="tooltip" data-placement="bottom"
                        title="调节音量" disabled>
                    <i class="glyphicon glyphicon-volume-up"></i>
                </button>
                <button type="button" id="restart" class="btn btn-default" data-toggle="tooltip" data-placement="bottom"
                        title="重启" disabled>
                    <i class="glyphicon glyphicon-off"></i>
                </button>
                <button type="button" id="deleteRow" class="btn btn-danger" data-toggle="tooltip"
                        data-placement="bottom" title="删除" disabled>
                    <i class="glyphicon glyphicon-trash"></i>
                </button>
            </div>

        </div>
        <table id="bttable">
            <!--<thead>-->
            <!--<tr>-->
            <!--<th data-field="state" data-checkbox="true"></th>-->
            <!--<th data-field="id" data-sortable="true">序号</th>-->
            <!--<th data-field="name" data-sortable="true" data-editable="true">姓名</th>-->
            <!--<th data-field="age" data-sortable="true">年龄</th>-->
            <!--<th data-field="gender" data-sortable="true">性别</th>-->
            <!--<th data-field="desc" data-sortable="false">备注</th>-->
            <!--</tr>-->
            <!--</thead>-->
        </table>
    </div>
</div>
