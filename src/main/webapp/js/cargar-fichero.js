function handleFileSelect(evt) {
    var files = evt.target.files; // Lista de objetos

    for (var i = 0, f; f = files[i]; i++) {
       	
      // Solamente procesar ficheros de imagen
      if (!f.type.match('image.*')) {
        continue;
      }

      var reader = new FileReader();

      // Closure para capturar informacion del fichero
      reader.onload = (function(theFile) {
        return function(e) {
          // Renderizar el thumbnail.
          var span = document.createElement('span');
          span.innerHTML = ['<img class="thumb" src="', e.target.result,
                            '" title="', escape(theFile.name), '"/>'].join('');
          document.getElementById('imagen_caratula').insertBefore(span, null);
          document.getElementById('imgActual').style.opacity="0.25";
        };
      })(f);

      reader.readAsDataURL(f);
    }
  }

  document.getElementById('caratula').addEventListener('change', handleFileSelect, false);