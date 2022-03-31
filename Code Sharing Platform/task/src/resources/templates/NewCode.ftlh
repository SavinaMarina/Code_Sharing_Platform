<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
    <title>Create</title>
    <script>
        function send() {
            let object = {
                "code": document.getElementById("code_snippet").value
            };
        
            let json = JSON.stringify(object);
        
            let xhr = new XMLHttpRequest();
            xhr.open("POST", '/api/code/new', false)
            xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
            xhr.send(json);
        
            if (xhr.status == 200) {
                alert("Success!");
            }
        }
    </script>
</head>
<body>
<form action="" method="post">
    <textarea id="code_snippet"> ... </textarea>
    <br>
    <button id="send_snippet" type="submit" onclick="send()">Submit</button>
</form>
</body>
</html>