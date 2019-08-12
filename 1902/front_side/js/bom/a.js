var ancles = document.querySelectorAll('a');

        for(var i=0; i<ancles.length; i++){
            ancles[i].addEventListener('click',function(e){
                e.preventDefault();
                location.replace(e.target.href);
                
            }, false);
        }