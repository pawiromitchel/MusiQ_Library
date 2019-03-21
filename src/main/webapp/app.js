loadSongsMenu();
var songDataList = [];
var responseText = [];

// const artist = document.getElementById("artist");
// artist.style.display = 'none';
//
// const album = document.getElementById("album");
// album.style.display = 'none';
//
// const artistType = document.getElementById("artistType");
// artistType.style.display = 'none';

function loadSongsMenu() {
    apiCall('song/random');
    if (JSON.parse(responseText)) {
        songDataList = JSON.parse(responseText);
        const songList = document.getElementById('songData');
        songDataList.forEach(song => {
            const data = `<tr class="table-light" style="background-color: rgba(225, 225, 225, 0.8)">
            <a href="#" style="color:black" onclick="getSelectedSong(${song.id})">
                    <p>Title: ${song.title}<br>
                    Artist: ${song.artist} <br>
                    Album:  ${song.album} <br></p>
                    </a></tr>
            `;
            songList.innerHTML += data;
        })
    }
}

function loadAllSongs() {
    let responseText = apiCall('song/list');
    console.log(responseText);
    if (responseText) {
        songDataList = responseText;
        const songList = document.getElementById('songData');
        songDataList.forEach(song => {
            const data = `
            <div class="row" >
            <a href="#" onclick="getSelectedSong(${song.id})">
                    <p>Title: ${song.title}<br>
                    Artist: ${song.artist} <br>
                    Album:  ${song.album} <br></p>
                    </a></div>
            `;
            songList.innerHTML += data;
        })
    }
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
    let newUrl = url + entity.toLowerCase();
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            responseText = this.responseText;
        }
    };
    xhttp.open('GET', newUrl, false);
    xhttp.send();
}

function loadArtist() {
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
    xhttp.open("GET", apiCall("artist") + "list");
    xhttp.send();
}

function loadAlbums() {
    let xhttp = new XMLHttpRequest();
    if (this.readyState == 4 && this.status == 200) {
        let albumList = JSON.parse(this.responseText);
    }
    xhttp.open("GET", apiCall("album") + "list");
    xhttp.send();
}
