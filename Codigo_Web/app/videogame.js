function VideogameObject(f1, f2, f3, f4, f5, f6) {
    
    this.title = f1;
    this.developer = f2;
    this.publisher = f3;
    this.year = f4;
    this.description = f5;
    this.genre = f6
    
    this.image = sessionStorage.urlImage;
    
    this.token = sessionStorage.token;
    
    this.toJsonString = function () { return JSON.stringify(this); };

};

function TokenObject() {
    
    this.tokenint = sessionStorage.token;
    this.toJsonString = function () { return JSON.stringify(this); };

};

function KeyObject(f1) {
    
    this.tokenint = sessionStorage.token;
    this.entityKey = f1;
    this.toJsonString = function () { return JSON.stringify(this); };

};

function addVideogame()
{
    //solo los que inicien sesión pueden ver agregar modelos
    if ("user" in sessionStorage)
    {
        try
        {
            //alert("token : " + sessionStorage.token);
        
            var myData = new VideogameObject(
            $("#title_vg").val(), 
            $("#developer_vg").val(),
            $("#publisher_vg").val(),
            $("#year_vg").val(),
            $("#description_vg").val(),
            $("#genre_vg").val()  
            );
            alert(myData.toJsonString());
        
                jQuery.ajax({
                    type: "POST",
                    url: "https://proyecto2-rafaelantoniocomonfo.appspot.com/_ah/api/videogames_api/v1/videogames/insert",
                    data: myData.toJsonString(),
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: function (response) {
                        // do something
                        alert (response.code + " " + response.message);
                    },
                
                    error: function (error) {            
                        // error handler
                        alert("error :" + error.message)
                    }
        
                });
        
            }
        catch(error)
        {
            alert(error);
        }
    }
    else
    {
       alert("No puedes agregar sin haber iniciado sesión");
       GoBack();
    }
}


function getVideogameList()
{
  try
  {
    //alert("token : " + sessionStorage.token);

    var myData = new TokenObject();
    
    alert(myData.toJsonString());

     jQuery.ajax({
           type: "POST",
           url: "https://proyecto2-rafaelantoniocomonfo.appspot.com/_ah/api/videogames_api/v1/videogames/list",
           data: myData.toJsonString(),
           contentType: "application/json; charset=utf-8",
           dataType: "json",
           success: function (response) {
                // do something
                
                alert (response.data);
           },
       
           error: function (error) {            
                // error handler
                alert("error :" + error.message)
           }

       });

   }
   catch(error)
   {
   	alert(error);
   }

}

//goes to the html to update a videogame and sets up a sessionStorage variable
function goToUpdateVideogame(theKey)
{
    sessionStorage.updateModelKey = theKey;

    window.location.href='/videogameupdate';
    //window.location = "/videogameupdate.html"; 
}

//requests and sets the values of the given object in the input boxes in videogameupdate.html on load
function setupUpdateVideogame()
{
    //alert("token: " + sessionStorage.token + ", key to update: " + sessionStorage.updateModelKey);

    var myData = new KeyObject(sessionStorage.updateModelKey);

    jQuery.support.cors = true;
    try
    {
        jQuery.ajax({
            type: "POST",
            url: "https://proyecto2-rafaelantoniocomonfo.appspot.com/_ah/api/videogames_api/v1/videogames/get",
            data: myData.toJsonString(),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (response) { //si no funciona, quizas se deba recorrer como arreglo, tal como se hace en getpublicdata.js?

                 entity = response.data;

                 entity.forEach(function(i)
                 {
                     $("#title_vg").val(i.title);
                     $("#developer_vg").val(i.developer);
                     $("#publisher_vg").val(i.publisher);
                     $("#year_vg").val(i.year);
                     $("#description_vg").val(i.description);
                     $("#genre_vg").val(i.genre);
                     $("#url_photo").val(i.image);
                     //$("#uploaded_file").val(i.image);
                     //uploadDemo(); //por si onChange() no se activa solo
                     sessionStorage.urlImage = i.image;
                 });
                 
            },
        
            error: function (error) {            
                 // error handler
                 alert("error on videogame add request:" + error.message)
                 GoBack(); //regresa para evitar que se repita el error
            }
 
        });
    }
    catch(e)
    {
      alert("error on videogame try add: " +  e);
      GoBack(); //regresa para evitar que se repita el error
    }
}

//makes the actual update when the user clicks the button in videogameupdate.html
function updateVideogame()
{
    addVideogame ();

    //we could also try just calling the update api from web_token_api
    deleteVideogame (sessionStorage.updateModelKey);
    
}

//borra el videojuego con la clave dada
function deleteVideogame(theKey)
{
    //alert("token: " + sessionStorage.token + ", entityKey: " + theKey);

    var myData = new KeyObject(theKey);

    jQuery.support.cors = true;
    try
    {
        jQuery.ajax({
            type: "POST",
            url: "https://proyecto2-rafaelantoniocomonfo.appspot.com/_ah/api/videogames_api/v1/videogames/delete",
            data: myData.toJsonString(),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (response) {
                 alert (response.message);
            },
            error: function (error) {            
                 // error handler
                 alert("error on videogame delete request:" + error.message)
            }
        });
    }
    catch(e)
    {
      alert("error on videogame try delete: " +  e);
    }

    GoBack(); //as update to see changes
}

//Sets the selected image as preview
function uploadDemo()
{
    var file_data = $("#uploaded_file").prop("files")[0];
    var form_data = new FormData();
    form_data.append("uploaded_file", file_data)

    jQuery.support.cors = true;
    try
    {
     $.ajax({
        url: "https://proyecto2-rafaelantoniocomonfo.appspot.com/up",
        dataType: 'text',
        cache: false,
        contentType: false,
        processData: false,
        data: form_data,
        type: 'post',
        crossDomain: true,
        success: function(response){

                        document.getElementById("preview").src=response;

                        sessionStorage.urlImage = response;

                        document.getElementById("url_photo").value = response;
        }
      });
    }
    catch(e)
    {
      alert("error : " +  e);
     }
}

//Goes back to index.html
function GoBack()
{
    //window.history.back();
    window.location = "/";
}
