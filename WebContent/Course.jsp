<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Course Management</title>
</head>
<body>
	<h2>Course Management</h2>
	<s:actionmessage />
	<s:form action="resetCourse">
		<s:textfield name="id" label="Course Id" />
		<s:textfield name="name" label="Course Name" size="44" />
		<s:textfield name="schoolfee" label="Shoolfee" />
		<s:textfield name="noOfLearners" label="Number of Learners" />
		
		<s:date id="date" name="startDate" format="dd/MM/yyyy"/>
		
		
		<s:textfield value="%{date}" name="startDate" label="Start Date (dd/MM/yyyy)" />
		<s:radio name="finished" label="Finished ?"
			list="#{'true':'Yes', 'false':'No'}" />
		<s:textarea name="description" label="Desccription" rows="3" cols="44" />
		<tr>
			<td>&nbsp;</td>
			<td><s:submit value="Insert" action="insertCourse"
					theme="simple" /> <s:submit value="Update" action="updateCourse"
					theme="simple" /> <s:submit value="Delete" action="deleteCourse"
					theme="simple" /> <input type="button" value="Reset"
				onclick="location.replace('resetCourse')" /></td>
		</tr>
	</s:form>
	<hr>
	<hr>
	<ul>
		<s:iterator value="courses">
			<li><a href="editCourse?id=${id}">${name}</a></li>
		</s:iterator>
	</ul>
</body>
</html>