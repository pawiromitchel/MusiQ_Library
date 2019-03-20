function getAllSongs() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let songDataList = JSON.parse(this.responseText);
            let song = '<div class="row"> ';

            // for (let index = 0; index < songDataList.length; index++) {
            for (let index = 0; index < songDataList.length; index++) {
                song +=
                    '<p style="color: black">Title: ' + songDataList[index].title + '<br>' +
                    'Artist: ' + songDataList[index].artist + '<br>' +
                    'Album: ' + songDataList[index].album + '<br></p>'
                ;
            }
            song += '</div>';
            document.getElementById("fullSongList").innerHTML = song;
        }
    };
    xhttp.open("GET", "http://localhost:8080/musiQ_library/api/song/list");
    xhttp.send();
}
