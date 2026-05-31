package com.example.eventmaster.data.repository;

import com.example.eventmaster.data.local.database.EventMasterDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class CategoryRepository_Factory implements Factory<CategoryRepository> {
  private final Provider<EventMasterDatabase> dbProvider;

  public CategoryRepository_Factory(Provider<EventMasterDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public CategoryRepository get() {
    return newInstance(dbProvider.get());
  }

  public static CategoryRepository_Factory create(
      javax.inject.Provider<EventMasterDatabase> dbProvider) {
    return new CategoryRepository_Factory(Providers.asDaggerProvider(dbProvider));
  }

  public static CategoryRepository_Factory create(Provider<EventMasterDatabase> dbProvider) {
    return new CategoryRepository_Factory(dbProvider);
  }

  public static CategoryRepository newInstance(EventMasterDatabase db) {
    return new CategoryRepository(db);
  }
}
