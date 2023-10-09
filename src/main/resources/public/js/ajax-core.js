const BASE="http://localhost";
const PORT="8081";
const CONTEXT_PATH = "/api";
const URL = BASE + ":" + PORT + CONTEXT_PATH;

class AjaxCore {

    constructor() { }

    static callByUrl(verb, path, id) {
        const urlParam = (id ? '/' + id : '');
        return $.ajax({
            type: verb,
            url: URL + path + urlParam,
            crossDomain: true,
            crossOrigin: true,
            contentType: 'application/json',
            error: function (xhr, status, errorThrown) {
                alert(status, errorThrown);
                console.log('xhr: ' + JSON.stringify(xhr.responseJSON));
                console.log('status: ' + status);
                console.log('errorThrown: ' + errorThrown);
            }
        });
    }


    static callByBody(verb, path, formData) {
        return $.ajax({
            type: verb,
            url: URL + path,
            crossDomain: true,
            crossOrigin: true,
            data: formData,
            contentType: 'application/json',
            error: function (xhr, status, errorThrown) {
                alert(status, errorThrown);
                console.log('xhr: ' + JSON.stringify(xhr.responseJSON));
                console.log('status: ' + status);
                console.log('errorThrown: ' + errorThrown);
            }
        });
    }
}
