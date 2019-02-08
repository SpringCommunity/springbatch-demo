<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo project for Spring Batch - Author Dinh Duc Thinh</title>
</head>
<body>
   <#-- Print today time to the screen -->
   <#assign aDateTime = .now>
   <#assign aDate = aDateTime?date>
   ${aDate?iso_utc}
   ${happyNewYear}
</body>
</html>