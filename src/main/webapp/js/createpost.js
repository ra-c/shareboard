function togglePostType(e){
    if($(e).is("#text-button")){
        console.log('test')
        $(e).addClass("post-type-button-selected");
        $("#image-button").removeClass("post-type-button-selected");
        $("#post-type").val("text");
        $("#text-field").removeAttr("hidden");
        $("#img").attr("hidden", true);
    } else if ($(e).is("#image-button")){
        console.log('test2')
        $(e).addClass("post-type-button-selected");
        $("#text-button").removeClass("post-type-button-selected");
        $("#post-type").val("image");
        $("#img").removeAttr("hidden");
        $("#text-field").attr("hidden", true);
    }
}