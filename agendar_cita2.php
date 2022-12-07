<!DOCTYPE html>

<html lang="es">

<head>
    <style>
        .datepicker {
            padding: 15px !important;
        }
        .select2-container--default .select2-selection--single{
            height: 38px !important;
            padding-top: 4px !important;
        }
    </style>
    <?php
    require_once('shared/head_agendar_cita.php');
    ?>
    <script src="js/bootstrap-datepicker.min.js"></script>
    <script src="js/sweetalert.min.js"></script>
    <script src="js/jquery.validate.min.js"></script>

    <script src="js/bootstrap-datepicker.es.js"></script>
    <script defer src="js/moment.min.js">
    </script>
    <link rel="stylesheet" href="css/jquery.timepicker.css">
    <script src="js/jquery.timepicker.js"></script>

    <!-- select search -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/js/select2.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/css/select2.min.css" />
    
    <script type="text/javascript">
        $(document).ready(function() {

            $("#cedula").on("keyup", function() {
                $('#id').val("");
                $('#tel').val("");
                $('#email').val("");
                $('#nombre').val("");

                var value = $(this).val().toLowerCase();
                if (value.length >= 8 && value.length <= 13) {
                    $.ajax({
                        type: "POST",
                        url: "./php/agendar_cita.php?action=cedula",
                        data: {
                            cedula: value
                        },
                        success: function(response) {
                            response = JSON.parse(response);
                            if (response != false) {
                                $('#id').val(response.id);
                                $('#nombre').val(response.nombre);
                                $('#tel').val(response.telefono);
                                $('#email').val(response.correo);
                                // $('#lada option[value="' + response.lada + '"]').attr("selected", true);
                                $('#lada').val(response.lada).trigger('change.select2');
                            }
                        },
                        error: function(XMLHttpRequest, textStatus, errorThrown) {}
                    });

                }
            });
            $(".select_lada").select2({
                tags: true
            });
        });

        $(document).on('change', '#fecha', function(){
            var fecha = $("#fecha").val();
            var fechaFormato = moment(fecha, "DD/MM/YYYY").format("YYYY-MM-DD");

            var id_cliente = $("#id").val();

            console.log($('#fecha').val());
            console.log(fechaFormato);
            console.log(id_cliente);

            $.ajax({
                type: "GET",
                url: "./php/cita.php?action=validar_cliente_cita&id_cliente="+id_cliente+"&opcion=administracionCita&fecha="+fechaFormato,
                success: function(response) {
                    response = JSON.parse(response);
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {}
            });
        });

        $(function() {
            var dateToday = new Date();
            $("#fecha").datepicker({
                language: 'es',
                startDate: dateToday
            });

            $('#hora').timepicker();
        });

        function buscarEstilista() {
            $('#colaborador').html('');

            if ($("#fecha") && $("#hora")) {
                var fecha = $("#fecha").val();
                var servicio = $("#clasificacion").val();
                var fechaServidor = moment(fecha, "DD/MM/YYYY").format("YYYY-MM-DD");
                var hora = $("#hora").val();
            }

            $.ajax({
                type: 'POST',
                url: './php/agendar_cita.php?action=estilistas',
                data: {
                    fecha: fechaServidor,
                    hora: hora,
                    servicio: servicio
                },
                success: function(response) {
                    response = JSON.parse(response);
                    $.each(response, function(index, co) {
                        $('#colaborador').append($('<option>', {
                            value: co.id,
                            text: co.nombre
                        }));
                    });
                    var options = $("#colaborador > option");

                    var random = Math.floor(options.length * (Math.random() % 1));

                    options.attr('selected', false)
                        .eq(random).attr('selected', true);
                }
            });
        }

        function resetEstilistas() {
            $('#colaborador').html('');
            buscarEstilista();
        }

        function get_categorias() {
            $('#categoria').html('');
            $.ajax({
                type: 'GET',
                url: './php/public.php?action=categorias-activas',
                success: function(response) {
                    response = JSON.parse(response);
                    var tema_item;
                    $.each(response, function(index, tema) {
                        $('#categoria').append($('<option>', {
                            value: tema.id,
                            text: tema.nombre
                        }));
                    });

                }
            });
        }

        function getLadas() {
            $('#lada').html('');
            $.ajax({
                type: 'POST',
                url: './php/public.php?action=ladas',
                success: function(response) {
                    response = JSON.parse(response);
                    var tema_item;
                    $.each(response, function(index, tema) {
                        $('#lada').append($('<option>', {
                            value: tema.id,
                            text: tema.pais + ' - ( ' + tema.lada + ')'
                        }));
                    });
                }
            });
        }

        function get_precios(id) {
            $.ajax({
                type: 'POST',
                url: './php/agendar_cita.php?action=precio-servicio',
                data: {
                    id: id,
                },
                success: function(response) {

                    response = JSON.parse(response);
                    $('#servicio_name').text(response.nombre);
                    $('#precio_max').text(response.max);
                    $('#precio_min').text(response.min);
                }
            });
        }


        function agregarCita() {
            var clasificacion = $("#clasificacion").val();

            get_precios(clasificacion);
            var form = $('#frm_agenda_cita')[0];
            var formData = new FormData(form);
            var date = moment($("#fecha").val(), "DD/MM/YYYY");
            formData.delete("fecha");
            formData.append("fecha", date.format("YYYY-MM-DD"));
            if ($('#frm_agenda_cita').valid()) {
                $.ajax({
                    type: "POST",
                    url: "./php/agendar_cita.php?action=solicitarCita",
                    data: formData,
                    contentType: false,
                    processData: false,
                    success: function(response) {
                        var fecha = $("#fecha").val();
                        var hora = $("#hora").val();
                        $('#fecha_name').text(fecha + " a las " + hora);
                        $('#frm_agenda_cita')[0].reset();
                        $('#clasificacion').html('');
                        $('#colaborador').html('');
                        $('#info').modal('show');
                    },
                    error: function(jqXHR, textStatus, errorThrown) {}


                });
            }
        }

        //initialize method on load
        function init() {
            get_categorias();
            getLadas();
        }
        $().ready(function() {
            // validate comment form
            var tel = $("#tel").val();
            var cedula = $("#cedula").val();
            preg_match('/^[0-9]{10}+$/', $tel);
            preg_match('/^[0-9]{13}+$/', $cedula);
            $("#frm_agenda_cita").validate({

                messages: {
                    cedula: "Por favor, introduzca su cédula no debe ser menor a 13 dígitos",
                    tel: "Por favor, introduzca su lada y celular",
                    categoria: "Por favor, selecciona una categoría",
                    clasificacion: "Por favor, selecciona una clasificación",
                    fecha: "Por favor, selecciona una fecha",
                    hora: "Por favor, selecciona la hora",
                    email: "Por favor, introduzca correo",
                }

            });
        });

        init();

        function validaNum() {
            if (event.keyCode < 45 || event.keyCode > 57)
                event.returnValue = false;
        }

        function get_clasificaciones(id) {
            $('#clasificacion').html('');

            $.ajax({
                url: "./php/public.php?action=servicios&id=" + id.value,
                method: "GET",
                dataType: "json",
                success: function(response) {
                    $.each(response, function(index, tema) {
                        $('#clasificacion').append($('<option>', {
                            value: tema.id,
                            text: tema.nombre
                        }));
                    });

                }
            });
        }
    </script>
</head>

<body>
    <?php
    require_once('shared/navbar.php');
    ?>


    <div class="container">
        <div class="card text-center mt-5">
            <div class="card-header bg-ab4193 color-eafafb">
                <p class="h1-responsive"> Agendar una Cita </p>

            </div>
            <div class="card-body">
                <p class="h3-responsive color-412f3f"> Agenda tu cita en un par de minutos, solo ten a la mano tu Cédula
                    y rellana nuestro formulario, los campos que tengan * son necesarios para darte un excelente
                    servicio. </p>

                <form method="post" autocomplete="off" id="frm_agenda_cita" enctype="multipart/form-data" class="row color-412f3f">
                    <input type="hidden" name="id" id="id" value="0">

                    <div class="form-group col-sm-12 col-md-6 ">
                        <label for="cedula" class="control-label mt-2">Ingresa Cédula *:</label>
                        <input type="text" class="form-control" id="cedula" name="cedula" placeholder="00100000001" minlength="13" maxlength="13" onKeypress="validaNum();" required />
                    </div>
                    <div class="form-group col-sm-12 col-md-6 ">
                        <label for="nombre" class="control-label mt-2">Nombre *:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="" required />
                    </div>
                    <div class="form-group  col-sm-12 col-md-6">
                        <label for="email" class="control-label mt-2">E-mail *:</label>
                        <input type="email" class="form-control" id="email" name="email" required />
                    </div>
                    <!--  -->
                    <div class="form-group  col-sm-12 col-md-6">
                        <label for="tel" class="control-label mt-2">Celular *:</label>
                        <div class="input-group col-md-12">
                            <!-- <select class="input-group-text" id="lada" name="lada" required>
                            </select> -->
                            <select class="select_lada" id="lada" style="width: 200px !important; height: 50px !important;">
                            </select>
                            <input type="tel" class="form-control" id="tel" name="tel" minlength="10" maxlength="10" onKeypress="validaNum();" required />
                        </div>
                    </div>
                    <!--  -->
                    <div class="form-group col-sm-12 col-md-6">
                        <label for="categoria" class="control-label mt-2">Categoría *:</label>
                        <select class="form-control" placeholder="Selecciona la categoría" onchange="get_clasificaciones(this);" id="categoria" name="categoria" required>
                        </select>
                    </div>
                    <div class="form-group  col-sm-12 col-md-6">
                        <label for="clasificacion" class="control-label mt-2">Servicio *:</label>
                        <select class="form-control" placeholder="Selecciona la clasificación" id="clasificacion" name="clasificacion" required>
                        </select>
                    </div>
                    <div class="form-group  col-sm-12 col-md-6">
                        <label for="fecha" class="control-label mt-2">Fecha *:</label>
                        <input class="form-control" id="fecha" name="fecha" onchange="resetEstilistas()" placeholder="fecha -- " type="text" required />

                    </div>
                    <div class="form-group  col-sm-12 col-md-6">
                        <label for="hora" class="control-label mt-2">Hora *:</label>
                        <input class="form-control" id="hora" name="hora" onchange="buscarEstilista()" required />
                    </div>

                    <div class="form-group  col-sm-12 col-md-12">
                        <label for="colaborador" class="control-label mt-2">Estilista:</label>
                        <select class="form-control" id="colaborador" name="colaborador">
                        </select>
                    </div>
                </form>


            </div>
            <div class="card-footer text-muted">
                <a onclick="agregarCita()" type="button" class="modal-footer center-div font-weight-bold h2-responsive text-white text-center bg-2194bd" style="text-decoration:none;border-radius: 5px;">
                    Apartar mi cita
                </a>
            </div>
        </div>

    </div>

    <?php
    require_once('shared/footer.php');
    ?>

    <div id="info" class="modal fade">
        <div class="modal-dialog modal-md" role="document">
            <div class="modal-content">
                <div class="modal-header text-white bg-412f3f">
                    <h4 class="modal-title w-100 center-div" id="myModalLabel">Información</h4>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <p class="h3-responsive color-ab4193"> La solicitud de tu cita fue enviada
                        <p class="h6-responsive color-2194bd">
                            En breve te mandaremos un mensaje <b>v&iacute;a whatsapp</b>
                            con la confirmaci&oacute;n de tu cita.
                        </p>
                    </div>
                    </p>

                </div>
                <a data-dismiss="modal" type="button" class="modal-footer center-div font-weight-bold h2-responsive text-white text-center  bg-412f3f" style="text-decoration:none">
                    CONFIRMAR
                </a>
            </div>
        </div>
    </div>

</body>

</html>