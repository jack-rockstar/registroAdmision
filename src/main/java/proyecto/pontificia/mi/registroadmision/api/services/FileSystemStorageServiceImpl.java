package proyecto.pontificia.mi.registroadmision.api.services;

import jakarta.annotation.PostConstruct;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileSystemStorageServiceImpl {
    private final  static  String STORAGE_LOCATION = "mediafile";

    @PostConstruct
    public  void init(){
        try{
            Path storageLocation = Paths.get(STORAGE_LOCATION);
            if(!Files.exists(storageLocation)){
                Files.createDirectory(Paths.get(STORAGE_LOCATION));
            }
        } catch (IOException ex){
           throw new RuntimeException("No se pudo crear el almacen de datos",ex);
        }
    }

    public String store(MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        String filename = UUID.randomUUID()+"."+ StringUtils.getFilenameExtension(originalFilename);

        try{
            if(file.isEmpty()){
                throw  new RuntimeException("No se pudo almacenar un archivo vacio "+originalFilename);
            }
            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, Paths.get(STORAGE_LOCATION).resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException ex){
            throw  new RuntimeException("Error al almacenar archivo", ex);
        }
        return  filename;
    }


    public Resource  loadAsResource(String filename) throws FileNotFoundException {
        try{
            Path path = Paths.get(STORAGE_LOCATION).resolve(filename);
            Resource resource = new UrlResource(path.toUri());
            if(!resource.exists() || !resource.isReadable()) {
                throw  new FileNotFoundException("El archivo no existe: "+filename);
            }

            return resource;
        }catch (MalformedURLException ex){
            throw  new FileNotFoundException("El archivo no ha sido encontrado: "+filename);
        }
    }

    public  void delete(String filename){
        Path path = Paths.get(STORAGE_LOCATION).resolve(filename);
        try{
            FileSystemUtils.deleteRecursively(path);
        }catch (IOException ex){
            throw new RuntimeException("No se pudo eliminar el archivo", ex);
        }
    }
}
