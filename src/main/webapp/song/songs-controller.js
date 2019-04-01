loadAllSongs();
var responseText = [];

function loadAllSongs() {
    apiCall('GET', 'song/list', null);
    if (JSON.parse(responseText)) {
        let songDataList = JSON.parse(responseText);
        const songList = document.getElementById('songTable');
        songDataList.forEach(song => {
            const data = `
            <tr class="table-light" style="background-color: rgba(225, 225, 225, 0.8)">
                    <td id="song">
                        <a href="./song/song-detail.html?id=${song.id}" style="color:black"">${song.title}</a>
                     </td>
                    <td id="artist">${song.album.artist.artistName}</td>
                    <td id="album">${song.album.albumTitle}</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-sm" onclick="viewSong(${song})">
                            <i class="fas fa-eye"></i>
                        </button>
                        <button type="button" class="btn btn-danger btn-sm" onclick="deleteSong(${song})">
                            <i class="fas fa-times-circle"></i>
                        </button>
                    </td>
                    </tr>
            `;
            window.sessionStorage.setItem(`${song.id}`, JSON.stringify(song));
            songList.innerHTML += data;
        });
    }
}

function apiCall(method, entity) {
    let url = "http://localhost:8080/musiQ_library/api/";
    let newUrl = url + entity.toLowerCase();
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            responseText = this.responseText;
        }
    };

    xhttp.onload = function () {
        if (this.status === 200 && method === "DELETE") {
            alert('Success')
        } else if (this.status === 400) {
            alert('Fail');
        }
    };

    if (method === 'GET') {
        xhttp.open(method, newUrl, false);
        xhttp.send();
    } else if (method === 'DELETE') {
        xhttp.open(method, newUrl, true);
        xhttp.setRequestHeader('Content-Type', 'application/json');
        xhttp.send();
    }
}

function viewSong(song) {
    window.location = `song-detail.html?id=${song.id}`;
}

function deleteSong(song) {
    const dialog = confirm("Are you sure you want to delete " + song.name);
    if (dialog) {
        apiCall('DELETE', `song/${song.id}`);
    }
}
