<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<label>タスク<br />
<input type="text" name="content" value="${tasks.content}" />
</label>
<br /><br />
<input type="hidden" name="jobs" value="${jobs}" />
<button type="submit">追加する</button>
