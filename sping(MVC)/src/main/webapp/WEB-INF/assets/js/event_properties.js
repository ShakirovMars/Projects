ymaps.ready(init);
var myMap;

function init () {
    myMap = new ymaps.Map("map", {
        center: [ 55.7985, 49.1064], // Казань
        zoom: 11
    }, {
        balloonMaxWidth: 200,
        searchControlProvider: 'yandex#search'
    });

    // Обработка события, возникающего при щелчке
    // левой кнопкой мыши в любой точке карты.
    // При возникновении такого события откроем балун.
    myMap.events.add('click', function (e) {
        if (!myMap.balloon.isOpen()) {
            var coords = e.get('coords');

            ymaps.geocode(coords, {
                result: 1
            }).then(function (res) {
                var result = res.geoObjects.get(0);
                var description = result.properties.get("text");
                
                var $contentBodyElem = $("#contentBalloon");

                $contentBodyElem.find("#address").val(description);
                $contentBodyElem.find("#x").val(result.geometry.getCoordinates()[0]);
                $contentBodyElem.find("#y").val(result.geometry.getCoordinates()[1]);

                result.properties.set({
                    balloonContentHeader: description,
                });

                result.options.set('preset', 'islands#redIcon');

                myMap.geoObjects.add(result);
            });
        }
        else {
            myMap.balloon.close();
        }
    });
}

   
 