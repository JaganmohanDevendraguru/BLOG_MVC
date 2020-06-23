package com.example.blog_mvc.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.blog_mvc.dao.PostDao;
import com.example.blog_mvc.model.Post;
import com.example.blog_mvc.model.PostDetails;
import com.example.blog_mvc.service.PostService;
import com.example.blog_mvc.util.ActiveStatus;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao dao;
	private Logger log = LoggerFactory.getLogger(PostServiceImpl.class);
	private static final int MAX_CHAR = 400;

	@Override
	public List<Post> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Post> findAll(String status) {
		return dao.findAll(status);
	}

	@Override
	public List<Post> findAllByDateAndStatus(String status, Date date) {
		return dao.findAllByDateAndStatus(status, date);
	}

	@Override
	public int updatePost(Post post) {
		Date date = Calendar.getInstance().getTime();
		post.setLastUpdateTime(date);
		if(post.getPostStatus().equals(ActiveStatus.PUBLISHED.getCode()))
			post.setPostDate(date);
		return dao.updatePost(post);
	}

	@Override
	public int savePost(Post post) {
		Date date = Calendar.getInstance().getTime();
		post.setLastUpdateTime(date);
		post.setPostDate(date);
		return dao.savePost(post);
	}

	@Override
	public int deletePost(int postId, int userId) {
		java.sql.Timestamp time = new Timestamp(Calendar.getInstance().getTimeInMillis());
		return dao.deletePost(postId, userId, time);
	}

	@Override
	public Post findByPostById(int uid, int pid) {
		return dao.findPostById(uid, pid);
	}

	@Override
	public Post findByPostById(int pid) {
		return dao.findPostById(pid);
	}

	@Override
	public List<Post> findAllByUser(int uid) {
		return dao.findAllByUser(uid);
	}
	
	@Override
	public List<PostDetails> fullPostDetails() {
		return fullPostDetails(null);
	}

	@Override
	public List<PostDetails> fullPostDetails(String status) {
		List<PostDetails> pds = dao.findAllDetails(status);
		for (PostDetails pd : pds) {
			StringBuilder sbPost = new StringBuilder(pd.getPostContent().substring(0,
					pd.getPostContent().length() < MAX_CHAR ? pd.getPostContent().length() : MAX_CHAR));
			sbPost.append("<p class=\"text-primary font-weight-italic\"><a href=\"blogs/" + pd.getPostId()
					+ "\">Continue reading...</a></p>");
			pd.setPostContent(sbPost.toString().trim());
		}
		return pds;
	}

	@Override
	public PostDetails singlePostDetails(int postId) {
		return dao.singlePostDetails(postId);
	}

	@Override
	public void upload(MultipartFile file, String directory) {
		String fileType = file.getContentType();
		String name = file.getName();
		long size = file.getSize() / 1024;
		Path fileNameAndPath = Paths.get(directory, file.getOriginalFilename());
		try {
			Files.write(fileNameAndPath, file.getBytes());
			log.info("Uploaded file" + fileType + "with the name" + name + "and the size is " + size + "KB");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Post> findAllByUser(int id, int limit) {
		return dao.findAllByUser(limit, limit);
	}

	@Override
	public List<Map<String, Object>> getRecentPostsByUser(int uid, int limit) {
		return dao.getRecentPostsByUser(uid, limit);
	}

	@Override
	public List<Map<String, Object>> getRecentPostsByUser(int uid, int limit, String status) {
		log.info("status :" + status);
		if (status != null && status.equals(ActiveStatus.DRAFT.getCode())) {
			return dao.getRecentPostsByUser(uid, limit, status);
		}
		return dao.getRecentPostsByUser(uid, limit, "P");
	}

	public File[] showFiles(String directory) {
		File folder = new File(directory);
		return folder.listFiles();
	}

}
