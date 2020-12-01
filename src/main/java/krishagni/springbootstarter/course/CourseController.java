package krishagni.springbootstarter.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import krishagni.springbootstarter.topic.Topic;

@RestController				//Automatically converted to JSON Response
public class CourseController {

	@Autowired				//Connecting the CourseService instance 
	private CourseService courseService;
	
		@RequestMapping("/topics/{topicId}/courses")
		public List<Course> getAllCourses(@PathVariable("topicId") String topicId)
		{
			return courseService.getAllCourses(topicId);
		} 
		
		@RequestMapping("/topics/{topicId}/courses/{id}")
		public Optional<Course> getCourse(@PathVariable("id") String id)
		{
			return courseService.getCourse(id);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")  //map certain method when POST request is made to "/courses"
		public void addCourse(@RequestBody Course course, @PathVariable("topicId") String topicId)				//Convert a part of request to an instance of course
		{
			course.setTopic(new Topic(topicId, "", ""));
			courseService.addCourse(course);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{Id}")  //map certain method when POST request is made to "/courses"
		public void updateCourse(@RequestBody Course course, @PathVariable("topicId") String topicId, @PathVariable("id") String id)				//Convert a part of request to an instance of course
		{
			course.setTopic(new Topic(topicId, "", ""));
			courseService.updateCourse(course);
		}

		@RequestMapping(method=RequestMethod.DELETE, value="/courses/{id}")
		public void deleteCourse(@PathVariable("id") String id)
		{
			courseService.deleteCourse(id);
		}
}
