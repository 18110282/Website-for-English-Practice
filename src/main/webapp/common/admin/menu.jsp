<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/admin-guideline-listen-list.html" var="listenGuidelineListUrl">
    <c:param name="urlType" value="url_list"/>
</c:url>
<c:url value="/admin-user-list.html" var="userListUrl">
    <c:param name="urlType" value="url_list"/>
</c:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>
    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large">
            <button class="btn btn-success">
            </button>

            <button class="btn btn-info">
            </button>

            <button class="btn btn-warning">
            </button>

            <button class="btn btn-danger">
            </button>
        </div>
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <ul class="nav nav-list">
        <li class="active">
            <a href="index.html">
                <i class="menu-icon fa fa-music"></i>
                <span class="menu-text"> Hướng dẫn nghe </span>
            </a>

            <b class="arrow"></b>
        </li>
        <li class="">
            <a href="index.html">
                <i class="menu-icon fa fa-users"></i>
                <span class="menu-text"> Quản lí người dùng </span>
            </a>

            <b class="arrow"></b>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-book"></i>
                <span class="menu-text"> Quản lí bài tập </span>

                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="">
                    <a href="tables.html">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Thêm audio
                    </a>

                    <b class="arrow"></b>
                </li>

                <li class="">
                    <a href="jqgrid.html">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Thêm hình ảnh
                    </a>

                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <div class="sidebar-toggle sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>