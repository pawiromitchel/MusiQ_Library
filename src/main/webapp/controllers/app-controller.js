loadSongsMenu();
var songDataList = [];
var responseText = [];

function addAlbumField() {
    const btn = document.getElementById('actAlbum');
    if (btn.style.display === "") {
        btn.style.display = 'none';
        const album = `
        <input class="form-control" id="album" placeholder="Album" type="text">
        `;
        document.getElementById('albumField').innerHTML += album;

    } else {
        btn.style.display = 'block';
    }
}

function addArtistFields() {
    const btn = document.getElementById('actArtist');
    if (btn.style.display === "") {
        btn.style.display = 'none';
        const artistType = `
            <select class="custom-select" id="artistType">
                <option selected disabled>Choose...</option>
            </select>`;

        const artist = `
        <input class="form-control" id="artist" placeholder="Artist" type="text">`;
        document.getElementById('artistField').innerHTML += artist;
        document.getElementById('type').innerHTML += artistType;

        getArtistTypes();

    } else {
        btn.style.display = 'block';
    }
}

function loadSongsMenu() {
    apiCall('GET', 'song/random', null);
    if (JSON.parse(responseText)) {
        songDataList = JSON.parse(responseText);
        const songList = document.getElementById('songData');
        songDataList.forEach(song => {
            const data = `<tr class="table-light" style="background-color: rgba(225, 225, 225, 0.8)">
            <a href="./song-detail.html?id=${song.id}" id="selectedSong" style="color:black">
                    <p>Title: ${song.title}<br>
                    Artist: ${song.album.artist.artistName} <br>
                    Album:  ${song.album.albumTitle} <br></p>
                    </a></tr>
            `;
            window.sessionStorage.setItem(`${song.id}`, JSON.stringify(song));
            songList.innerHTML += data;
        })
    }
}

function apiCall(method, entity, body) {
    let url = "http://localhost:8080/musiQ_library/api/";
    let newUrl = url + entity.toLowerCase();
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            responseText = this.responseText;
        }
    };

    if (method === 'GET') {
        xhttp.open(method, newUrl, false);
        xhttp.send();
    } else if (method === 'POST') {
        xhttp.open(method, newUrl, true);
        xhttp.setRequestHeader('Content-Type', 'application/json');
        xhttp.send(JSON.stringify(body));
        // xhttp.send(body);
    }
}

function loadArtist() { //TODO
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

function loadAlbums() { //TODO
    let xhttp = new XMLHttpRequest();
    if (this.readyState == 4 && this.status == 200) {
        let albumList = JSON.parse(this.responseText);
    }
    xhttp.open("GET", apiCall("album") + "list");
    xhttp.send();
}

function postData() {

    let songTitle = document.getElementById('title').value;
    let artist = null;
    let artistType = null;
    let album = null;
    let songData = {};

    if (document.getElementById('album')) {
        album = document.getElementById('album').value;
    }

    if (document.getElementById('artistType') &&
        document.getElementById('artist')) {
        artistType = document.getElementById('artistType').value;
        artist = document.getElementById('artist').value;
    }

    validate(songTitle, artist, artistType, album);

    if (songTitle) {
        if (album && artist && artistType) {
            songData = {
                "title": songTitle,
                "album": {
                    "albumTitle": album,
                    "artist": {
                        "artistName": artist,
                        "artistType": {
                            "artistType": artistType
                        }
                    }
                }
            }
        } else if (album) {
            songData = {
                "title": songTitle,
                "album": {
                    "albumTitle": album
                }
            };
        } else {
            songData = {
                "title": songTitle,
            }
        }
        apiCall('POST', 'song/add', songData);
    }
}

function validate(songTitle, artist, artistType, album) {

    if (songTitle === '' || artist === '' || artistType === '' || album === '') {

    }
}

function getArtistTypes() {
    const typeOption = document.getElementById('artistType');
    apiCall("GET", 'artist/types', null);
    let data = JSON.parse(this.responseText);
    data.forEach(type => {
        const option =
            `<option value="${type}"><b>${type}</b></option>`;
        typeOption.innerHTML += option;
    });
}
