var myMap;
ymaps.ready(init);
function init () {
    myMap = new ymaps.Map('map', {
        center: [53.9000000, 27.5666700],
        zoom: 10
    }, {
        searchControlProvider: 'yandex#search'
    });
}