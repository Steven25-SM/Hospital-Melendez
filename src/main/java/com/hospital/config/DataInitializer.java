package com.hospital.config;

import com.hospital.entity.Medico;
import com.hospital.entity.Paciente;
import com.hospital.entity.Usuario;
import com.hospital.repository.MedicoRepository;
import com.hospital.repository.PacienteRepository;
import com.hospital.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hospital.entity.Habitacion;
import com.hospital.repository.HabitacionRepository;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(
            UsuarioRepository usuarioRepository,
            PacienteRepository pacienteRepository,
            MedicoRepository medicoRepository,
            HabitacionRepository habitacionRepository
    ) {
        return args -> {

            if (usuarioRepository.findByNombreUsuario("admin").isEmpty()) {

                Usuario admin = new Usuario();

                admin.setNombreUsuario("admin");
                admin.setContrasena("admin123");
                admin.setRol("ADMIN");

                usuarioRepository.save(admin);

                System.out.println("=================================");
                System.out.println("Usuario ADMIN creado");
                System.out.println("Usuario: admin");
                System.out.println("=================================");
            }

                crearPaciente(
                        pacienteRepository,
                        usuarioRepository,
                        "Juan",
                        "Perez Garcia",
                        "70123456",
                        LocalDate.of(1998, 5, 14),
                        "M",
                        "Av. Los Olivos 123",
                        "987654321",
                        "juan.perez@gmail.com",
                        "juanp",
                        "123456"
                );

                crearPaciente(
                        pacienteRepository,
                        usuarioRepository,
                        "Maria",
                        "Lopez Torres",
                        "70234567",
                        LocalDate.of(2000, 8, 21),
                        "F",
                        "Jr. Lima 456",
                        "986543210",
                        "maria.lopez@gmail.com",
                        "marial",
                        "123456"
                );

                crearPaciente(
                        pacienteRepository,
                        usuarioRepository,
                        "Carlos",
                        "Ramirez Soto",
                        "70345678",
                        LocalDate.of(1995, 3, 10),
                        "M",
                        "Av. Central 789",
                        "985432109",
                        "carlos.ramirez@gmail.com",
                        "carlosr",
                        "123456"
                );

                crearPaciente(
                        pacienteRepository,
                        usuarioRepository,
                        "Ana",
                        "Flores Mendoza",
                        "70456789",
                        LocalDate.of(2002, 11, 5),
                        "F",
                        "Calle Las Flores 120",
                        "984321098",
                        "ana.flores@gmail.com",
                        "anaf",
                        "123456"
                );

                crearPaciente(
                        pacienteRepository,
                        usuarioRepository,
                        "Luis",
                        "Castillo Vargas",
                        "70567890",
                        LocalDate.of(1992, 7, 18),
                        "M",
                        "Av. Arequipa 321",
                        "983210987",
                        "luis.castillo@gmail.com",
                        "luisc",
                        "123456"
                );

                crearPaciente(
                        pacienteRepository,
                        usuarioRepository,
                        "Sofia",
                        "Torres Ramirez",
                        "70678901",
                        LocalDate.of(1999, 1, 27),
                        "F",
                        "Jr. Los Pinos 654",
                        "982109876",
                        "sofia.torres@gmail.com",
                        "sofiat",
                        "123456"
                );

                crearPaciente(
                        pacienteRepository,
                        usuarioRepository,
                        "Diego",
                        "Vargas Quispe",
                        "70789012",
                        LocalDate.of(1988, 9, 12),
                        "M",
                        "Av. Primavera 890",
                        "981098765",
                        "diego.vargas@gmail.com",
                        "diegov",
                        "123456"
                );

                crearPaciente(
                        pacienteRepository,
                        usuarioRepository,
                        "Valeria",
                        "Mendoza Ruiz",
                        "70890123",
                        LocalDate.of(2001, 6, 30),
                        "F",
                        "Calle Los Cedros 234",
                        "980987654",
                        "valeria.mendoza@gmail.com",
                        "valeriam",
                        "123456"
                );

                crearPaciente(
                        pacienteRepository,
                        usuarioRepository,
                        "Fernando",
                        "Gutierrez Diaz",
                        "70901234",
                        LocalDate.of(1990, 12, 3),
                        "M",
                        "Av. Javier Prado 567",
                        "979876543",
                        "fernando.gutierrez@gmail.com",
                        "fernandog",
                        "123456"
                );

                crearPaciente(
                        pacienteRepository,
                        usuarioRepository,
                        "Camila",
                        "Rojas Fernandez",
                        "71012345",
                        LocalDate.of(2003, 4, 16),
                        "F",
                        "Jr. Primavera 345",
                        "978765432",
                        "camila.rojas@gmail.com",
                        "camilar",
                        "123456"
                );

                crearPaciente(
                        pacienteRepository,
                        usuarioRepository,
                        "Miguel",
                        "Herrera Sanchez",
                        "71123456",
                        LocalDate.of(1985, 10, 9),
                        "M",
                        "Av. Grau 678",
                        "977654321",
                        "miguel.herrera@gmail.com",
                        "miguelh",
                        "123456"
                );

                crearPaciente(
                        pacienteRepository,
                        usuarioRepository,
                        "Daniela",
                        "Paredes Silva",
                        "71234567",
                        LocalDate.of(1997, 2, 25),
                        "F",
                        "Calle San Martin 901",
                        "976543210",
                        "daniela.paredes@gmail.com",
                        "danielap",
                        "123456"
                );

                crearPaciente(
                        pacienteRepository,
                        usuarioRepository,
                        "Jorge",
                        "Navarro Perez",
                        "71345678",
                        LocalDate.of(1993, 5, 7),
                        "M",
                        "Av. Universitaria 432",
                        "975432109",
                        "jorge.navarro@gmail.com",
                        "jorgeb",
                        "123456"
                );

                crearPaciente(
                        pacienteRepository,
                        usuarioRepository,
                        "Gabriela",
                        "Salazar Torres",
                        "71456789",
                        LocalDate.of(2000, 9, 19),
                        "F",
                        "Jr. Tacna 765",
                        "974321098",
                        "gabriela.salazar@gmail.com",
                        "gabrielas",
                        "123456"
                );

                crearPaciente(
                        pacienteRepository,
                        usuarioRepository,
                        "Ricardo",
                        "Molina Chavez",
                        "71567890",
                        LocalDate.of(1987, 1, 11),
                        "M",
                        "Av. Brasil 876",
                        "973210987",
                        "ricardo.molina@gmail.com",
                        "ricardom",
                        "123456"
                );

                System.out.println("15 pacientes creados.");

            if (medicoRepository.count() == 0) {

                crearMedico(
                        medicoRepository,
                        "Roberto",
                        "Fernandez Silva",
                        "CMP-10001",
                        "987111222",
                        "roberto.fernandez@hospital.com",
                        "Cardiología"
                );

                crearMedico(
                        medicoRepository,
                        "Patricia",
                        "Gomez Torres",
                        "CMP-10002",
                        "986222333",
                        "patricia.gomez@hospital.com",
                        "Pediatría"
                );

                crearMedico(
                        medicoRepository,
                        "Alberto",
                        "Ramirez Castillo",
                        "CMP-10003",
                        "985333444",
                        "alberto.ramirez@hospital.com",
                        "Medicina General"
                );

                crearMedico(
                        medicoRepository,
                        "Lucia",
                        "Mendoza Flores",
                        "CMP-10004",
                        "984444555",
                        "lucia.mendoza@hospital.com",
                        "Ginecología"
                );

                crearMedico(
                        medicoRepository,
                        "Fernando",
                        "Torres Vargas",
                        "CMP-10005",
                        "983555666",
                        "fernando.torres@hospital.com",
                        "Traumatología"
                );

                crearMedico(
                        medicoRepository,
                        "Claudia",
                        "Rojas Martinez",
                        "CMP-10006",
                        "982666777",
                        "claudia.rojas@hospital.com",
                        "Dermatología"
                );

                System.out.println("6 médicos creados.");
            }

            if (habitacionRepository.count() == 0) {

                crearHabitacion(habitacionRepository, "101", "Individual", "DISPONIBLE");
                crearHabitacion(habitacionRepository, "102", "Individual", "DISPONIBLE");
                crearHabitacion(habitacionRepository, "103", "Individual", "DISPONIBLE");

                crearHabitacion(habitacionRepository, "201", "Compartida", "DISPONIBLE");
                crearHabitacion(habitacionRepository, "202", "Compartida", "DISPONIBLE");
                crearHabitacion(habitacionRepository, "203", "Compartida", "DISPONIBLE");

                crearHabitacion(habitacionRepository, "301", "UCI", "DISPONIBLE");
                crearHabitacion(habitacionRepository, "302", "UCI", "DISPONIBLE");

                crearHabitacion(habitacionRepository, "401", "Emergencia", "DISPONIBLE");
                crearHabitacion(habitacionRepository, "402", "Maternidad", "DISPONIBLE");

                System.out.println("10 habitaciones creadas.");
            }

        };
    }

    private void crearPaciente(
            PacienteRepository pacienteRepository,
            UsuarioRepository usuarioRepository,
            String nombres,
            String apellidos,
            String dni,
            LocalDate fechaNacimiento,
            String sexo,
            String direccion,
            String telefono,
            String correo,
            String nombreUsuario,
            String contrasena
    ) {

        if (usuarioRepository.findByNombreUsuario(nombreUsuario).isPresent()) {
            return;
        }

        if (pacienteRepository.existsByDni(dni)) {
            return;
        }

        Paciente paciente = new Paciente();

        paciente.setNombres(nombres);
        paciente.setApellidos(apellidos);
        paciente.setDni(dni);
        paciente.setFechaNacimiento(fechaNacimiento);
        paciente.setSexo(sexo);
        paciente.setDireccion(direccion);
        paciente.setTelefono(telefono);
        paciente.setCorreo(correo);
        paciente.setEstado("ACTIVO");

        Paciente pacienteGuardado = pacienteRepository.save(paciente);


        Usuario usuario = new Usuario();

        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContrasena(contrasena);
        usuario.setRol("PACIENTE");
        usuario.setPaciente(pacienteGuardado);

        usuarioRepository.save(usuario);


        pacienteGuardado.setUsuario(usuario);

        pacienteRepository.save(pacienteGuardado);
    }

    private void crearMedico(
            MedicoRepository medicoRepository,
            String nombres,
            String apellidos,
            String colegiatura,
            String telefono,
            String correo,
            String especialidad
    ) {

        Medico medico = new Medico();

        medico.setNombres(nombres);
        medico.setApellidos(apellidos);
        medico.setColegiatura(colegiatura);
        medico.setTelefono(telefono);
        medico.setCorreo(correo);
        medico.setEspecialidad(especialidad);
        medico.setEstado("ACTIVO");

        medicoRepository.save(medico);
    }

    private void crearHabitacion(
            HabitacionRepository habitacionRepository,
            String numero,
            String tipo,
            String estado
    ) {

        Habitacion habitacion = new Habitacion();

        habitacion.setNumero(numero);
        habitacion.setTipo(tipo);
        habitacion.setEstado(estado);

        habitacionRepository.save(habitacion);
    }
}