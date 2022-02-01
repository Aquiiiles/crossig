(function () {
    var listLeftSide = document.getElementById("link-list-left");
    var listRightSide = document.getElementById("link-list-right");

    links = listLeftSide.querySelectorAll(".nav-item-link");

    for (const link of links) {
        var parentClasses = link.parentElement.classList;
        var li = document.createElement("li");
        li.classList = parentClasses;

        link.removeAttribute("style");
        li.appendChild(link);
        listRightSide.appendChild(li);
    }
})();
