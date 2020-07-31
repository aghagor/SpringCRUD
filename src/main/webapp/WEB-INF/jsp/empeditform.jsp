<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Edit Employee</h1>
<form:form method="post" action="editsave">
    <table>
        <tr>
            <td></td>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>Name :</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Salary :</td>
            <td><form:input path="salary"/></td>
        </tr>
        <tr>
            <td>Destination :</td>
            <td><form:input path="destination"/></td>
        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="Update"/></td>
        </tr>
    </table>
</form:form>
