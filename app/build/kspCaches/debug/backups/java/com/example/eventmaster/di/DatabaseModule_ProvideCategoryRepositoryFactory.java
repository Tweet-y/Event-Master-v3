package com.example.eventmaster.di;

import com.example.eventmaster.data.local.database.EventMasterDatabase;
import com.example.eventmaster.data.repository.CategoryRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class DatabaseModule_ProvideCategoryRepositoryFactory implements Factory<CategoryRepository> {
  private final Provider<EventMasterDatabase> databaseProvider;

  public DatabaseModule_ProvideCategoryRepositoryFactory(
      Provider<EventMasterDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public CategoryRepository get() {
    return provideCategoryRepository(databaseProvider.get());
  }

  public static DatabaseModule_ProvideCategoryRepositoryFactory create(
      javax.inject.Provider<EventMasterDatabase> databaseProvider) {
    return new DatabaseModule_ProvideCategoryRepositoryFactory(Providers.asDaggerProvider(databaseProvider));
  }

  public static DatabaseModule_ProvideCategoryRepositoryFactory create(
      Provider<EventMasterDatabase> databaseProvider) {
    return new DatabaseModule_ProvideCategoryRepositoryFactory(databaseProvider);
  }

  public static CategoryRepository provideCategoryRepository(EventMasterDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideCategoryRepository(database));
  }
}
