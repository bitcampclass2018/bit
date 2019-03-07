<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
        window.fbAsyncInit = function() {
            FB.init({
                appId: '302606807116615',
                cookie: true, // enable cookies to allow the server to access 
                // the session
                xfbml: true, // parse social plugins on this page
                version: 'v3.1' // The Graph API version to use for the call
            });

            // Now that we've initialized the JavaScript SDK, we call 
            // FB.getLoginStatus().  This function gets the state of the
            // person visiting this page and can return one of three states to
            // the callback you provide.  They can be:
            //
            // 1. Logged into your app ('connected')
            // 2. Logged into Facebook, but not your app ('not_authorized')
            // 3. Not logged into Facebook and can't tell if they are logged into
            //    your app or not.
            //
            // These three cases are handled in the callback function.
            
            var callback = function(response){
                console.log(response);
                //statusChangeCallback(response);
                if(response.status==='connected'){
                    document.querySelector('#authBtn').value = 'Logout';
                }else{
                    document.querySelector('#authBtn').value= 'Login';
                }
            }
            
            FB.getLoginStatus(callback);

        };



        /*sdk 가져오기*/
        (function(d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s);
            js.id = id;
            js.src = "https://connect.facebook.net/en_US/sdk.js";
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));

    </script>
</head>
<body>
<h1>fff</h1>
<input type="button" id="authBtn" value="checking.." >
</body>
</html>