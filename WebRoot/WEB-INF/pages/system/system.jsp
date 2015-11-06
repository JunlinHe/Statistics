<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/app/system/js/system.js"></script>

<div class="sky-custom-tabs">
    <ul class="nav nav-tabs" role="tablist" id="sysTabs">
        <li role="presentation" class="active">
            <a href="#s_statistics" class="sky-icon-link" aria-controls="statistics" role="tab" data-toggle="tab">
                <span class="glyphicon glyphicon-stats"></span> 统计
            </a>
        </li>
        <li role="presentation">
            <a href="#s_setting" class="sky-icon-link" aria-controls="setting" role="tab" data-toggle="tab">
                <span class="glyphicon glyphicon-cog"></span> 系统设置
            </a>
        </li>
        <li role="presentation">
            <a href="#s_resolution" class="sky-icon-link" aria-controls="resolution" role="tab" data-toggle="tab">
                <span class="glyphicon glyphicon-hd-video"></span> 模板分辨率
            </a>
        </li>
        <li role="presentation">
            <a href="#s_dbbackup" class="sky-icon-link" aria-controls="dbbackup" role="tab" data-toggle="tab">
                <span class="glyphicon glyphicon-floppy-disk"></span> 数据库备份
            </a>
        </li>
        <li role="presentation">
            <a href="#s_authorization" class="sky-icon-link" aria-controls="authorization" role="tab" data-toggle="tab">
                <span class="glyphicon glyphicon-king"></span> 终端授权
            </a>
        </li>
        <li role="presentation">
            <a href="#s_usermng" class="sky-icon-link" aria-controls="usermng" role="tab" data-toggle="tab">
                <span class="glyphicon glyphicon-user"></span> 用户管理
            </a>
        </li>
        <li role="presentation">
            <a href="#s_logmng" class="sky-icon-link" aria-controls="logmng" role="tab" data-toggle="tab">
                <span class="glyphicon glyphicon-list-alt"></span> 日志管理
            </a>
        </li>
    </ul>
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane fade in active" id="s_statistics">
            <jsp:include page="statistics.jsp"/>
        </div>
        <div role="tabpanel" class="tab-pane fade" id="s_setting"></div>
        <div role="tabpanel" class="tab-pane fade" id="s_resolution"></div>
        <div role="tabpanel" class="tab-pane fade" id="s_dbbackup"></div>
        <div role="tabpanel" class="tab-pane fade" id="s_authorization"></div>
        <div role="tabpanel" class="tab-pane fade" id="s_usermng"></div>
        <div role="tabpanel" class="tab-pane fade" id="s_logmng"></div>
    </div>
</div>
