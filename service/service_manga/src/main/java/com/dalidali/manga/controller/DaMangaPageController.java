package com.dalidali.manga.controller;


import com.dalidali.manga.config.RootPath;
import com.dalidali.manga.entity.DaMangaChapter;
import com.dalidali.manga.entity.DaMangaPage;
import com.dalidali.manga.entity.vo.MangaPageLiteVo;
import com.dalidali.manga.entity.vo.MangaPageVo;
import com.dalidali.manga.mapper.DaMangaPageMapper;
import com.dalidali.manga.service.DaMangaChapterService;
import com.dalidali.manga.service.DaMangaDetailService;
import com.dalidali.manga.service.DaMangaPageService;
import com.dalidali.utils.ImageUtils;
import com.dalidali.utils.Result;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qinda
 * @since 2020-08-26
 */
@RestController
@RequestMapping("/manga/page")
@CrossOrigin
public class DaMangaPageController {

//    @RequestMapping(value = "/getPage/{mid}/{cid}/{pid}",produces = {MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_JPEG_VALUE})
//    public byte[] getImage(@PathVariable String mid,@PathVariable String cid,@PathVariable String pid) throws IOException {
//
//        String rootPath = RootPath.MANGA_ROOT_PATH;
//        System.out.println(1);
//        byte[] image = ImageUtils.getImage(rootPath+"/"+mid+"/"+cid+"/"+pid);
//        return image;
//    }
//
//    @RequestMapping(value = "/get",produces = {MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_JPEG_VALUE})
//    public byte[] getImageByPath(@RequestBody String path) throws IOException {
//        System.out.println(path);
//        String rootPath = RootPath.MANGA_ROOT_PATH;
//        byte[] image = ImageUtils.getImage(rootPath+path);
//        System.out.println(rootPath+path);
//        return image;
//    }
    @Autowired
    private DaMangaDetailService service;

    @Autowired
    private DaMangaChapterService chapterService;

    @Autowired
    private DaMangaPageService pageService;

    @Autowired
    private DaMangaPageMapper pageMapper;
    @RequestMapping("/test")
    public String test(){

        int fileNum = 0, folderNum = 0;
        File file = new File("D:\\IdeaProject\\data\\manga\\声之形");
        String mid = "1306929016404299777";
        // 比较器：按照-分割，-前的数字排序
        Comparator<File> chapterComparator = (o1, o2)->{
            String o1name = o1.getName();
            String o2name = o2.getName();
            o1name = o1name.split("-")[0];
            o2name = o2name.split("-")[0];
            return (int) (Double.parseDouble(o1name)-Double.parseDouble(o2name));
        };
        // 按照 . 分割，获取图片的名字，排序
        Comparator<File> pageComparator = (o1,o2)->{
            String o1name = o1.getName();
            String o2name = o2.getName();
            o1name = o1name.split("\\.")[0];
            o2name = o2name.split("\\.")[0];
            return (int) (Double.parseDouble(o1name)-Double.parseDouble(o2name));
        };
        LinkedList<File> list = new LinkedList<>();
        list.addAll(Arrays.asList(file.listFiles()));
        // 对章节排序
        list.sort(chapterComparator);
        System.out.println(list.toString());
        if (file.exists()) {
            if (null == file.listFiles()) {
                return "";
            }
            // 遍历所有的章节
            for(File chapter : list) {

                DaMangaChapter daMangaChapter = new DaMangaChapter();
                daMangaChapter.setMangaId(mid);
                daMangaChapter.setTitle(chapter.getName());
                chapterService.save(daMangaChapter);
                String cid = daMangaChapter.getId();

                //得到该章节下的所有图片
                File[] pages = chapter.listFiles();
                assert pages != null;
                ArrayList<File> pageList = new ArrayList<>(Arrays.asList(pages));

                //排序
                pageList.sort(pageComparator);
                int cnt = 1;
                List<DaMangaPage> toInsertList = new ArrayList<>();
                for(File f : pageList){
                    DaMangaPage p = new DaMangaPage();
                    p.setChapterId(cid);
                    p.setMangaId(mid);
                    String title = f.getName().substring(0,f.getName().lastIndexOf("."));
                    System.out.println(title);
                    p.setTitle(title);
                    p.setPageNum(cnt++);
                    String url = "";
                    File grandparent = f.getParentFile().getParentFile();
                    File parent = f.getParentFile();
                    url = "/"+grandparent.getName()+"/"+parent.getName()+"/"+f.getName();
                    p.setContentPath(url);

                    toInsertList.add(p);
//                    pageService.save(p);
                }
                pageMapper.insertBatch(toInsertList);
                System.out.println(pageList.toString());

            }
//            while (!list.isEmpty()) {
//                File chapter = list.removeFirst();
//
//                DaMangaChapter daMangaChapter = new DaMangaChapter();
//                daMangaChapter.setMangaId(mid);
//                daMangaChapter.setTitle(chapter.getName());
//                chapterService.save(daMangaChapter);
//                String cid = daMangaChapter.getId();
//
////                System.out.println(chapter.getName());
////                System.out.println(chapter.getParentFile().getName());
//                File[] pages = chapter.listFiles();
//                if (null == pages) {
//                    continue;
//                }
//                int cnt = 1;
//                for (File f : pages) {
//                    if (f.isDirectory()) {
//                        System.out.println("文件夹:" + f.getCanonicalPath());
//                        list.add(f);
//                        folderNum++;
//                    } else {
//                        System.out.println("文件:" + f.getCanonicalPath());
//
//                        DaMangaPage p = new DaMangaPage();
//                        p.setChapterId(cid);
//                        p.setMangaId(mid);
//                        String title = f.getName().substring(0,f.getName().lastIndexOf("."));
//                        System.out.println(title);
//                        p.setTitle(title);
//                        p.setPageNum(cnt++);
//                        String path = f.getCanonicalPath();
//                        String url = "";
//                        File grandparent = f.getParentFile().getParentFile();
//                        File parent = f.getParentFile();
//                        url = "/"+grandparent.getName()+"/"+parent.getName()+"/"+f.getName();
//                        p.setContentPath(url);
//                        pageService.save(p);
//                        fileNum++;
//                    }
//                }
//            }
        } else {
            System.out.println("文件不存在!");
        }
        System.out.println("文件夹数量:" + folderNum + ",文件数量:" + fileNum);
        return "yes";
    }

    @RequestMapping("/get/{chapterId}")
    public Result getPagesByChapterId(@PathVariable String chapterId){
        List<MangaPageVo> res = pageService.getPagesByChapterId(chapterId);

        return Result.ok().data("pages",res);
    }

    @RequestMapping("/getlite/{chapterId}")
    public Result getLitePagesByChapterId(@PathVariable String chapterId){
        List<MangaPageLiteVo> res = pageService.getLitePagesByChapterId(chapterId);

        return Result.ok().data("pages",res);
    }

}

