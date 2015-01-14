 
function logout()
{
    gapi.auth.signOut();
    location.reload();
}
function login() 
{
  var myParams = {
    'clientid' : '8636396516-t94onf4sh05p8dq2odoi3nvoo0jam6hf.apps.googleusercontent.com',
    'cookiepolicy' : 'single_host_origin',
    'callback' : 'loginCallback',
    'approvalprompt':'force',
    'scope' : 'https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/plus.profile.emails.read'
  };
  gapi.auth.signIn(myParams);
}
 
function loginCallback(result)
{
    if(result['status']['signed_in'])
    {
    	 alert("Login Success");
    	 window.location = "http://localhost:8465/AppOwnner/firstpage.xhtml";
        var request = gapi.client.plus.people.get(
        {
            'userId': 'me'
        });
        request.execute(function (resp)
        {
            var email = '';
            if(resp['emails'])
            {
            	 
                for(i = 0; i < resp['emails'].length; i++)
                {
                    if(resp['emails'][i]['type'] == 'account')
                    {
                        email = resp['emails'][i]['value'];
                    }
                }
            }
 
            var str = "Name:" + resp['displayName'] + "<br>";
             
            str += "Image:" + resp['image']['url'] + "<br>";
            str += "<img src='" + resp['image']['url'] + "' /><br>";
 
            str += "URL:" + resp['url'] + "<br>";
             
            str += "Email:" + email + "<br>";
             
            document.getElementById("profile").innerHTML=str;
        });
 
    }
 
}
function onLoadCallback()
{
    gapi.client.setApiKey('AIzaSyC6bo_Ul8xuLAKYsj4pc0HDKuCpj_KW_n0');
    gapi.client.load('plus', 'v1',function(){});
}
 
    
 
 
      (function() {
       var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
       po.src = 'https://apis.google.com/js/client.js?onload=onLoadCallback';
       var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
     })();
      
      
      