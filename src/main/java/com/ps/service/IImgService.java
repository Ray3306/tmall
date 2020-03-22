package com.ps.service;

import java.util.List;
import java.util.Map;

import com.ps.vo.Img;

public interface IImgService {

	Map<String, List<Img>> queryProductImgList(String pid);
}
