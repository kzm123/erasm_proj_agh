package erasm_proj_agh

import erasm_proj_agh.Faculty;
import erasm_proj_agh.Major;
import erasm_proj_agh.University;

class UniversityController {

    def show() {
        if (params.id) {
            def university = University.get(params.id)
            def faculties = Faculty.findAllWhere(university: university)
            render(view: 'show', model: [university: university, faculties: faculties])
        } else {
            redirect(controller: 'main')
        }
    }
    
    def faculty() {
        if (params.id) {
            def faculty = Faculty.get(params.id)
            def majors = Major.findAllWhere(faculty: faculty)
            render(view: 'faculty', model: [faculty: faculty, majors: majors])
        } else {
            redirect(controller: 'main')
        }
    }
    
    def major() {
        if (params.id) {
            def major = Major.get(params.id)
            render(view: 'major', model: [major: major])
        } else {
            redirect(controller: 'main')
        }
    }
    
    def addFaculty() {
        if (request.method == 'POST' && session.userid) {
            
            def faculty = new Faculty()
            def university = University.findByName(params.university)
            
            for (param in params) {
                if (param.key == 'university') {
                    faculty.university = university
                } else {
                    faculty.properties[param.key] = param.value
                }
            }
            
            if (!faculty.save()) {
                render(view: 'show', model: [university: university, faculty: faculty])
            } else {
                redirect(controller: 'university', action: 'faculty', params: [id: faculty.id])
            }
        }
    }
    
    def addMajor() {
        if (request.method == 'POST' && session.userid) {
            
            def major = new Major()
            def faculty = Faculty.findByName(params.faculty)
            
            for (param in params) {
                if (param.key == 'faculty') {
                    major.faculty = faculty
                } else {
                    major.properties[param.key] = param.value
                }
            }
            
            if (!major.save()) {
                render(view: 'faculty', model: [faculty: faculty, major: major])
            } else {
                redirect(controller: 'university', action: 'major', params: [id: major.id])
            }
        }
    }
    
}
