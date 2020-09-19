package com.dalidali.manga;

import com.dalidali.manga.entity.DaMangaChapter;
import com.dalidali.manga.entity.DaMangaDetail;
import com.dalidali.manga.entity.DaMangaPage;
import com.dalidali.manga.mapper.DaMangaPageMapper;
import com.dalidali.manga.service.DaMangaChapterService;
import com.dalidali.manga.service.DaMangaDetailService;
import com.dalidali.manga.service.DaMangaPageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @program: manga
 * @description:
 * @author: qinda
 * @create: 2020-08-31 15:54
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddManga {

    @Autowired
    private DaMangaDetailService service;

    @Autowired
    private DaMangaChapterService chapterService;

    @Autowired
    private DaMangaPageService pageService;

    @Autowired
    private DaMangaPageMapper pageMapper;
    public static DaMangaDetail getManga(){
        DaMangaDetail da = new DaMangaDetail();
        da.setTitle("声之形");
        da.setAuthor("大今良时");
        da.setCover("1.png");
        da.setIntro("先天聋哑少女西宫硝子转入了一所新小学，听障的生理缺陷令她饱受同班同学的欺凌，其中，最嚣张的是以石田将也为首的小团体。无休止的恶作剧给硝子带去了无法挽回的伤害，最终转学。多年后，心怀愧疚、想要赎罪的少年石田将也与聋哑少女西宫硝子再次相遇……");
        da.setIsFinished(true);
        return da;

    }

    @Test
    public void test(){
        DaMangaDetail manga = getManga();
        service.save(manga);
//        String a = "123";
//        String b = "123";
//        String c = new String("123");
//        System.out.println(a == b);
//        System.out.println(a == c);
//        service.removeById("1300408495413530625");
    }

    @Test
    public void a() throws IOException {
        int fileNum = 0, folderNum = 0;
        File file = new File("D:\\IdeaProject\\data\\manga\\声之形");
        String mid = "1300410003907592193";

        LinkedList<File> list = new LinkedList<>();
        System.out.println(Arrays.toString(file.listFiles()));
        if (file.exists()) {
            if (null == file.listFiles()) {
                return;
            }
            list.addAll(Arrays.asList(file.listFiles()));
            while (!list.isEmpty()) {
                File chapter = list.removeFirst();

                DaMangaChapter daMangaChapter = new DaMangaChapter();
                daMangaChapter.setMangaId(mid);
                daMangaChapter.setTitle(chapter.getName());
                chapterService.save(daMangaChapter);
                String cid = daMangaChapter.getId();

//                System.out.println(chapter.getName());
//                System.out.println(chapter.getParentFile().getName());
                File[] pages = chapter.listFiles();
                if (null == pages) {
                    continue;
                }
                int cnt = 1;
                for (File f : pages) {
                    if (f.isDirectory()) {
                        System.out.println("文件夹:" + f.getCanonicalPath());
                        list.add(f);
                        folderNum++;
                    } else {
                        System.out.println("文件:" + f.getCanonicalPath());

                        DaMangaPage p = new DaMangaPage();
                        p.setChapterId(cid);
                        p.setMangaId(mid);
                        String title = f.getName().substring(0,f.getName().lastIndexOf("."));
                        System.out.println(title);
                        p.setTitle(title);
                        p.setPageNum(cnt++);
                        String path = f.getCanonicalPath();
                        String url = "";
                        File grandparent = f.getParentFile().getParentFile();
                        File parent = f.getParentFile();
                        url = "/"+grandparent.getName()+"/"+parent.getName()+"/"+f.getName();
                        p.setContentPath(url);
                        pageService.save(p);
                        fileNum++;
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
        System.out.println("文件夹数量:" + folderNum + ",文件数量:" + fileNum);
    }

    @Test
    public void b(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("10");
        list.add("1.1");
        list.add("2");
        list.add("20");

        list.sort((o1, o2) -> {
            return o1.compareTo(o2);
        });
        System.out.println(list.toString());
    }


    @Test
    public void c() throws IOException {
        int fileNum = 0, folderNum = 0;
        File file = new File("D:\\IdeaProject\\data\\manga\\声之形");
        String mid = "1306929016404299777";
        // 比较器：按照-分割，-前的数字排序
        Comparator<File> chapterComparator = (o1,o2)->{
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
                return;
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
                    p.setGmtCreate(new Date());
                    p.setGmtModified(new Date());
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
    }

    @Test
    public void testInsertBatch(){
        List<DaMangaPage> t = new ArrayList<>();
        for(int i=0;i<5;i++){
            DaMangaPage p = new DaMangaPage();
            p.setMangaId("1");
            p.setChapterId("2");
            p.setTitle("ee");
            p.setPageNum(i);
            t.add(p);
        }
        pageMapper.insertBatch(t);
    }
}
