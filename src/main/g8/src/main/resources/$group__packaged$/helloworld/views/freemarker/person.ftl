<#-- @ftlvariable name="" type="$group$.views.PersonView" -->
<html>
    <body>
        <!-- calls getPerson().getFullName() and sanitizes it -->
        <h1>Hello, \${person.fullName?html}!</h1>
    </body>
</html>