<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <meta property="og:url" content="http://127.0.0.1/sentence/onesentence/one/1" />
    <meta property="og:type" content="website" />
    <meta property="og:title" content="한문장" />
    <meta property="og:description" content="한문장내용" />
    <meta property="og:image" content="https://www.your-domain.com/path/image.jpg" />
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>

<body>
    <input type="text" id="Title">
    <input id="Content" type="text">
    <input type="button" id="facebookShare" value="공유">
  
  <div class="fb-share-button" 
    data-href="http://127.0.0.1/sentence/onesentence/one/1" 
    data-layout="button_count">
  </div>
  
  <script>(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.0";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));
  
  $('div').on("click", function() {
  	
  	alert("버튼클릭");
  	
      /* FB.ui({
          method: 'share_open_gragh',
          action_type: 'og.shares',
          action_properties: JSON.stringify({
              object: {
                  'og:url':
              }
          });
      }); */

  });
  
  </script>

    
</body>

