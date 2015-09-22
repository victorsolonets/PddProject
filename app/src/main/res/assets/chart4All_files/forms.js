function process_response(data,replacement){
    if(data.hasOwnProperty('text')){
        $(replacement).replaceWith('<div>'+data['text']+'</div>')
    }

    if(data.hasOwnProperty('eval')){
        eval(data['eval']);
    }

    if(data.hasOwnProperty('append')){
        $(replacement).append('<div class="success">'+data['append']+'</div>')
    }

    if(data.hasOwnProperty('redirect')){
        document.location.href=data['redirect']
    }
}

function submitform(e){
    $('.has-error').remove();
    $('.success').remove();
    $.ajax({
        type: "POST",
        url: $(e).attr('action'),
        data: $(e).serialize(),
        success: function(data){
            process_response(JSON.parse(data),e)
        },
        error:  function(resp) {
            var errors = JSON.parse(resp.responseText);
            for (error in errors['errors']) {
                $('input[name="'+error+'"]').before('<span class="has-error">'+errors['errors'][error]+'</span>');
            }
        }
    });
}

function loganswer(id,complect,theme){
    if(complect)
        $.get('/loganswer/?id='+id+'&complect='+complect+'&theme='+theme);
    else
        $.get('/loganswer/?id='+id);
}

function load_variants(lang){
    if(lang=='ru')
        var url = '/pdd/variants/';
    else
        var url = '/pdr/variants/';
    $.ajax({
        type: "GET",
        url: url+'?id='+$('#my-dropdown10 option:selected').val(),
        success: function(data){
            $('#my-dropdown11').html(data)
        }
    });
}