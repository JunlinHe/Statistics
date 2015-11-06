<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/app/terminal/js/terminal.js"></script>

<div class="sky-custom-tabs">
    <ul class="nav nav-tabs" role="tablist" id="terminalTabs">
        <li role="presentation" class="active">
            <a href="#t_info" class="sky-icon-link" aria-controls="info" role="tab" data-toggle="tab">
                <span class="glyphicon glyphicon-console"></span> 终端信息
            </a>
        </li>
        <li role="presentation">
            <a href="#t_monitor" class="sky-icon-link" aria-controls="monitor" role="tab" data-toggle="tab">
                <span class="glyphicon glyphicon-eye-open"></span> 终端监控
            </a>
        </li>
        <li role="presentation">
            <a href="#t_setting" class="sky-icon-link" aria-controls="setting" role="tab" data-toggle="tab">
                <span class="glyphicon glyphicon-cog"></span> 终端设置
            </a>
        </li>
        <li role="presentation">
            <a href="#t_group" class="sky-icon-link" aria-controls="group" role="tab" data-toggle="tab">
                <span class="glyphicon glyphicon-th-list"></span> 分组管理
            </a>
        </li>
    </ul>
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane fade in active" id="t_info">
            <jsp:include page="info.jsp"/>
        </div>
        <div role="tabpanel" class="tab-pane fade" id="t_monitor"></div>
        <div role="tabpanel" class="tab-pane fade" id="t_setting"></div>
        <div role="tabpanel" class="tab-pane fade" id="t_group"></div>
    </div>
</div>

