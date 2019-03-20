getAllData();

// function loader() {
//     var elem = document.getElementById("loading");
//     var width = 1;
//     var id = setInterval(frame, 15);
//     function frame() {
//         if (width === 100) {
//             clearInterval(id);
//             document.getElementById("loading").hidden;
//         } else {
//             width++;
//             elem.style.width = width + '%';
//         }
//     }
// }

function getAllData() {
    const BASE_URL = "http://localhost:8080/musiQ_library/api";
    loadSongsMenu(BASE_URL);
    // loadArtist(BASE_URL);
}

function loadSongsMenu(url) {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let songDataList = JSON.parse(this.responseText);
            let song = '<div class="row"> ';

            // for (let index = 0; index < songDataList.length; index++) {
            for (let index = 0; index < 5; index++) {
                song +=
                    '<a href="#" onclick="getSelectedSong(' + songDataList[index].id + ')">' +
                    '<p>Title: ' + songDataList[index].title + '<br>' +
                    'Artist: ' + songDataList[index].artist + '<br>' +
                    'Album: ' + songDataList[index].album + '<br></p>' +
                    '</a>'
                ;
            }
            song += '</div>';
            document.getElementById("songData").innerHTML = song;
        }
    };
    xhttp.open("GET", url + "/song/list");
    xhttp.send();
}

function getSelectedSong(id) {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let selectedSong = JSON.parse(this.responseText);
            console.log(selectedSong);
        }
    };
    xhttp.open("GET", apiCall('song') + id);
    xhttp.send();
}

function apiCall(entity) {
    let url = "http://localhost:8080/musiQ_library/api/";
    if (entity.toLowerCase() === 'song') {
        return url + entity + '/';
    } else if (entity.toLowerCase() === 'artist') {
        return url + entity + '/';
    } else if (entity.toLowerCase() === 'album') {
        return url + entity + '/';
    }
}

function loadArtist(url) {
    let xhttp = new XMLHttpRequest();
    if (this.readyState == 4 && this.status == 200) {
        let artistList = JSON.parse(this.responseText);
        let artist = '<div class="row">';

        for (index = 0; index < 4; index++) {
            artist +=
                '<a href="#">' +
                '<p>' + artistList[index].artistName + '</p>' +
                '</a>'
            ;
        }
        artist += '</div>';
        document.getElementById("artistData").innerHTML = artist;
    }
    xhttp.open("GET", url + "/artist/list");
    xhttp.send();
}

function loadAlbums(url) {
    let xhttp = new XMLHttpRequest();
    if (this.readyState == 4 && this.status == 200) {
        let albumList = JSON.parse(this.responseText);
    }
    xhttp.open("GET", url + "/album/list");
    xhttp.send();
}
