//function loadMap(marker_arr) {
//    const marker_arr_json = JSON.parse(marker_arr)
//    var mapOptions = {
//       center:new google.maps.LatLng(38.784027, -9.312023),
//       zoom:12
//    }
//    var map = new google.maps.Map(document.getElementById("mymap"),mapOptions);
//    for (let i = 0; i < marker_arr_json.length; i++) {
//        var marker = new google.maps.Marker({
//            position: new google.maps.LatLng(marker_arr_json[i]["latitude"], marker_arr_json[i]["longitude"]),
//            map: map,
//        });
//    }
//}


function loadMap(locations) {
    var locations_json;
    var center_lat = 38.784027;
    var center_long = -9.312023;
    if(locations.length > 3) {
        locations_json = JSON.parse(locations)
        center_lat = locations_json[0]["lat"]
        center_long = locations_json[0]["long"]
    }
    var mapOptions = {
       center:new google.maps.LatLng(center_lat, center_long),
       zoom:12
    }
    var map = new google.maps.Map(document.getElementById("mymap"),mapOptions);
    for (let i = 0; i < locations_json.length; i++) {
        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(locations_json[i]["lat"], locations_json[i]["long"]),
            map: map
        });
    }
}


function showAlert() {
    console.log("coisas para loggar!");
}